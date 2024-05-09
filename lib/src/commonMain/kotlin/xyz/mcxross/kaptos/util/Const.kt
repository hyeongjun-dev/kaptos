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

package xyz.mcxross.kaptos.util

const val APTOS_COIN = "0x1::aptos_coin::AptosCoin"

val DEFAULT_CLIENT_HEADERS = mapOf(
  "x-aptos-client" to "aptos-kmp-sdk/0.1.0"
)

/**
 * The default number of seconds to wait for a transaction to be processed.
 *
 * This time is the amount of time that the SDK will wait for a transaction to be processed when waiting for
 * the results of the transaction.  It may take longer based on network connection and network load.
 */
const val DEFAULT_TXN_TIMEOUT_SEC = 20;