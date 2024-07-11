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
package xyz.mcxross.kaptos.account

import xyz.mcxross.kaptos.core.crypto.AnyPublicKey
import xyz.mcxross.kaptos.core.crypto.Secp256k1PrivateKey
import xyz.mcxross.kaptos.core.crypto.Signature
import xyz.mcxross.kaptos.model.AccountAddress
import xyz.mcxross.kaptos.model.AccountAddressInput
import xyz.mcxross.kaptos.model.HexInput
import xyz.mcxross.kaptos.model.SigningScheme
import xyz.mcxross.kaptos.transaction.authenticatior.AccountAuthenticator

/**
 * Signer implementation for the SingleKey authentication scheme. This extends a SingleKeyAccount by
 * adding signing capabilities through a valid private key. Currently, the only supported signature
 * schemes are Ed25519 and Secp256k1.
 *
 * Note: Generating a signer instance does not create the account on-chain.
 */
class SingleAccount(val privateKey: Secp256k1PrivateKey, val address: AccountAddressInput? = null) :
  Account() {

  override val publicKey: AnyPublicKey = AnyPublicKey(privateKey.publicKey())

  override val accountAddress: AccountAddress
    get() =
      if (address != null) {
        AccountAddress.from(address)
      } else {
        publicKey.authKey().deriveAddress()
      }

  override val signingScheme: SigningScheme
    get() = SigningScheme.SingleKey

  override fun signWithAuthenticator(message: HexInput): AccountAuthenticator {
    TODO("Not yet implemented")
  }

  override fun sign(message: HexInput): Signature {
    TODO("Not yet implemented")
  }
}
