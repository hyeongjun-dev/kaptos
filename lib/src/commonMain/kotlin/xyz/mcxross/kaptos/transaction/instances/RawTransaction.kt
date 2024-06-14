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
package xyz.mcxross.kaptos.transaction.instances

import kotlinx.serialization.Serializable
import xyz.mcxross.kaptos.model.AccountAddress
import xyz.mcxross.kaptos.model.TransactionPayload

@Serializable open class AnyRawTransactionInstance

@Serializable
data class RawTransaction(
  val sender: AccountAddress,
  val sequenceNumber: Long,
  val payload: TransactionPayload,
  val maxGasAmount: Long,
  val gasUnitPrice: Long,
  val expirationTimestampSecs: Long,
  val chainId: ChainId,
  val zero: Byte = 0,
) : AnyRawTransactionInstance()