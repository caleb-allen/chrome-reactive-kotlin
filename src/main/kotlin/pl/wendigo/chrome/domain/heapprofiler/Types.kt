package pl.wendigo.chrome.domain.heapprofiler

/**
 * Heap snapshot object id.
 */

typealias HeapSnapshotObjectId = String

/**
 * Sampling Heap Profile node. Holds callsite information, allocation statistics and child nodes.
 */

data class SamplingHeapProfileNode(
    /**
     * Function location.
     */
    val callFrame: pl.wendigo.chrome.domain.runtime.CallFrame,

    /**
     * Allocations size in bytes for the node excluding children.
     */
    val selfSize: Double,

    /**
     * Node id. Ids are unique across all profiles collected between startSampling and stopSampling.
     */
    val id: Int,

    /**
     * Child nodes.
     */
    val children: List<SamplingHeapProfileNode>
)

/**
 * A single sample from a sampling profile.
 */

data class SamplingHeapProfileSample(
    /**
     * Allocation size in bytes attributed to the sample.
     */
    val size: Double,

    /**
     * Id of the corresponding profile tree node.
     */
    val nodeId: Int,

    /**
     * Time-ordered sample ordinal number. It is unique across all profiles retrieved
  between startSampling and stopSampling.
     */
    val ordinal: Double
)

/**
 * Sampling profile.
 */

data class SamplingHeapProfile(
    /**
     *
     */
    val head: SamplingHeapProfileNode,

    /**
     *
     */
    val samples: List<SamplingHeapProfileSample>
)
