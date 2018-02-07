package pl.wendigo.chrome.domain.memory

/**
 * Memory pressure level.
 */
enum class PressureLevel {
    @com.fasterxml.jackson.annotation.JsonProperty("moderate") MODERATE,
    @com.fasterxml.jackson.annotation.JsonProperty("critical") CRITICAL;
}

/**
 * Heap profile sample.
 */

data class SamplingProfileNode(
  /**
   * Size of the sampled allocation.
   */
  val size : Double,

  /**
   * Number of sampled allocations of that size.
   */
  val count : Double,

  /**
   * Execution stack at the point of allocation.
   */
  val stack : List<String>
)

/**
 * Array of heap profile samples.
 */

data class SamplingProfile(
  /**
   *
   */
  val samples : List<SamplingProfileNode>
)

