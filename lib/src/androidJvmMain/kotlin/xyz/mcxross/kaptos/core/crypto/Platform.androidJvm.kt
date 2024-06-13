/*
 * Copyright 2024 McXross
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package xyz.mcxross.kaptos.core.crypto

import io.ktor.util.reflect.*
import xyz.mcxross.bcs.Bcs
import xyz.mcxross.kaptos.model.AnyRawTransaction
import xyz.mcxross.kaptos.transaction.builder.deriveTransactionType
import xyz.mcxross.kaptos.transaction.instances.RawTransaction
import xyz.mcxross.kaptos.util.RAW_TRANSACTION_SALT

actual fun generateSigningMessage(transaction: AnyRawTransaction): ByteArray {
  val rawTxn = deriveTransactionType(transaction)
  val hash = org.bouncycastle.jcajce.provider.digest.SHA3.Digest256()

  if (transaction.instanceOf(RawTransaction::class)) {
    hash.update(RAW_TRANSACTION_SALT.encodeToByteArray())
  }

  val body = Bcs.encodeToByteArray<RawTransaction>(rawTxn as RawTransaction)

  return hash.digest() + body
}

actual fun sign(message: ByteArray, privateKey: ByteArray): ByteArray {
  val signer = org.bouncycastle.crypto.signers.Ed25519Signer()
  val privateKeyParameters =
    org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters(privateKey, 0)
  signer.init(true, privateKeyParameters)
  signer.update(message, 0, message.size)
  return signer.generateSignature()
}
