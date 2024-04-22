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

package xyz.mcxross.kaptos.model

import xyz.mcxross.kaptos.client.ClientConfig

data class AptosSettings(
  val network: Network? = null,
  val fullNode: String? = null,
  val faucet: String? = null,
  val indexer: String? = null,
  val client: Client? = null,
  val clientConfig: ClientConfig? = null,
  val fullNodeConfig: FullNodeConfig? = null,
  val indexerConfig: IndexerConfig? = null,
  val faucetConfig: FaucetConfig? = null,
)
