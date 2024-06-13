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

import kotlinx.serialization.Serializable

sealed class Option<out T> {
  @Serializable data class Some<T>(val value: T) : Option<T>()

  @Serializable data object None : Option<Nothing>()

  fun unwrap(message: String = "None.unwrap"): T =
    when (this) {
      is Some -> value
      is None -> throw NoSuchElementException(message)
    }

  fun destruct(): T? =
    when (this) {
      is Some -> value
      is None -> null
    }
}
