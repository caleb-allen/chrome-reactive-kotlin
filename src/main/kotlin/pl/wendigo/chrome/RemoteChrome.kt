package pl.wendigo.chrome

/**
 * RemoteChrome represents session established via chrome's remote debugging protocol.
 */
class RemoteChrome internal constructor(private val api: RemoteChromeConnection) {

    /**
     * Register event mappings
     */
    init {
      api.registerMappings(mapOf(
      "DOM.setChildNodes" to pl.wendigo.chrome.domain.dom.SetChildNodesEvent::class.java,
      "DOM.childNodeCountUpdated" to pl.wendigo.chrome.domain.dom.ChildNodeCountUpdatedEvent::class.java,
      "CSS.styleSheetAdded" to pl.wendigo.chrome.domain.css.StyleSheetAddedEvent::class.java,
      "Target.targetDestroyed" to pl.wendigo.chrome.domain.target.TargetDestroyedEvent::class.java,
      "Target.detachedFromTarget" to pl.wendigo.chrome.domain.target.DetachedFromTargetEvent::class.java,
      "HeapProfiler.addHeapSnapshotChunk" to pl.wendigo.chrome.domain.heapprofiler.AddHeapSnapshotChunkEvent::class.java,
      "Database.addDatabase" to pl.wendigo.chrome.domain.database.AddDatabaseEvent::class.java,
      "DOMStorage.domStorageItemsCleared" to pl.wendigo.chrome.domain.domstorage.DomStorageItemsClearedEvent::class.java,
      "Animation.animationCanceled" to pl.wendigo.chrome.domain.animation.AnimationCanceledEvent::class.java,
      "Runtime.executionContextCreated" to pl.wendigo.chrome.domain.runtime.ExecutionContextCreatedEvent::class.java,
      "Runtime.consoleAPICalled" to pl.wendigo.chrome.domain.runtime.ConsoleAPICalledEvent::class.java,
      "Page.frameNavigated" to pl.wendigo.chrome.domain.page.FrameNavigatedEvent::class.java,
      "Network.requestServedFromCache" to pl.wendigo.chrome.domain.network.RequestServedFromCacheEvent::class.java,
      "DOM.inlineStyleInvalidated" to pl.wendigo.chrome.domain.dom.InlineStyleInvalidatedEvent::class.java,
      "DOM.shadowRootPushed" to pl.wendigo.chrome.domain.dom.ShadowRootPushedEvent::class.java,
      "CSS.fontsUpdated" to pl.wendigo.chrome.ChromeProtocolEvent::class.java,
      "CSS.styleSheetChanged" to pl.wendigo.chrome.domain.css.StyleSheetChangedEvent::class.java,
      "Runtime.exceptionRevoked" to pl.wendigo.chrome.domain.runtime.ExceptionRevokedEvent::class.java,
      "Debugger.resumed" to pl.wendigo.chrome.ChromeProtocolEvent::class.java,
      "Page.frameClearedScheduledNavigation" to pl.wendigo.chrome.domain.page.FrameClearedScheduledNavigationEvent::class.java,
      "DOMStorage.domStorageItemRemoved" to pl.wendigo.chrome.domain.domstorage.DomStorageItemRemovedEvent::class.java,
      "DOM.attributeModified" to pl.wendigo.chrome.domain.dom.AttributeModifiedEvent::class.java,
      "DOM.childNodeRemoved" to pl.wendigo.chrome.domain.dom.ChildNodeRemovedEvent::class.java,
      "DOM.shadowRootPopped" to pl.wendigo.chrome.domain.dom.ShadowRootPoppedEvent::class.java,
      "LayerTree.layerPainted" to pl.wendigo.chrome.domain.layertree.LayerPaintedEvent::class.java,
      "Debugger.breakpointResolved" to pl.wendigo.chrome.domain.debugger.BreakpointResolvedEvent::class.java,
      "Network.eventSourceMessageReceived" to pl.wendigo.chrome.domain.network.EventSourceMessageReceivedEvent::class.java,
      "Page.navigationRequested" to pl.wendigo.chrome.domain.page.NavigationRequestedEvent::class.java,
      "Network.requestWillBeSent" to pl.wendigo.chrome.domain.network.RequestWillBeSentEvent::class.java,
      "DOM.characterDataModified" to pl.wendigo.chrome.domain.dom.CharacterDataModifiedEvent::class.java,
      "Target.attachedToTarget" to pl.wendigo.chrome.domain.target.AttachedToTargetEvent::class.java,
      "ServiceWorker.workerVersionUpdated" to pl.wendigo.chrome.domain.serviceworker.WorkerVersionUpdatedEvent::class.java,
      "Inspector.detached" to pl.wendigo.chrome.domain.inspector.DetachedEvent::class.java,
      "Security.securityStateChanged" to pl.wendigo.chrome.domain.security.SecurityStateChangedEvent::class.java,
      "Page.javascriptDialogClosed" to pl.wendigo.chrome.domain.page.JavascriptDialogClosedEvent::class.java,
      "Page.screencastFrame" to pl.wendigo.chrome.domain.page.ScreencastFrameEvent::class.java,
      "Page.interstitialShown" to pl.wendigo.chrome.ChromeProtocolEvent::class.java,
      "Network.webSocketHandshakeResponseReceived" to pl.wendigo.chrome.domain.network.WebSocketHandshakeResponseReceivedEvent::class.java,
      "ServiceWorker.workerRegistrationUpdated" to pl.wendigo.chrome.domain.serviceworker.WorkerRegistrationUpdatedEvent::class.java,
      "Runtime.inspectRequested" to pl.wendigo.chrome.domain.runtime.InspectRequestedEvent::class.java,
      "Inspector.targetCrashed" to pl.wendigo.chrome.ChromeProtocolEvent::class.java,
      "Network.webSocketWillSendHandshakeRequest" to pl.wendigo.chrome.domain.network.WebSocketWillSendHandshakeRequestEvent::class.java,
      "Network.webSocketCreated" to pl.wendigo.chrome.domain.network.WebSocketCreatedEvent::class.java,
      "DOM.attributeRemoved" to pl.wendigo.chrome.domain.dom.AttributeRemovedEvent::class.java,
      "Debugger.scriptParsed" to pl.wendigo.chrome.domain.debugger.ScriptParsedEvent::class.java,
      "Debugger.paused" to pl.wendigo.chrome.domain.debugger.PausedEvent::class.java,
      "Page.frameStoppedLoading" to pl.wendigo.chrome.domain.page.FrameStoppedLoadingEvent::class.java,
      "Page.screencastVisibilityChanged" to pl.wendigo.chrome.domain.page.ScreencastVisibilityChangedEvent::class.java,
      "DOM.pseudoElementRemoved" to pl.wendigo.chrome.domain.dom.PseudoElementRemovedEvent::class.java,
      "DOM.distributedNodesUpdated" to pl.wendigo.chrome.domain.dom.DistributedNodesUpdatedEvent::class.java,
      "CSS.styleSheetRemoved" to pl.wendigo.chrome.domain.css.StyleSheetRemovedEvent::class.java,
      "Log.entryAdded" to pl.wendigo.chrome.domain.log.EntryAddedEvent::class.java,
      "HeapProfiler.reportHeapSnapshotProgress" to pl.wendigo.chrome.domain.heapprofiler.ReportHeapSnapshotProgressEvent::class.java,
      "HeapProfiler.lastSeenObjectId" to pl.wendigo.chrome.domain.heapprofiler.LastSeenObjectIdEvent::class.java,
      "Page.frameResized" to pl.wendigo.chrome.ChromeProtocolEvent::class.java,
      "Network.webSocketFrameReceived" to pl.wendigo.chrome.domain.network.WebSocketFrameReceivedEvent::class.java,
      "Network.webSocketFrameSent" to pl.wendigo.chrome.domain.network.WebSocketFrameSentEvent::class.java,
      "Tracing.dataCollected" to pl.wendigo.chrome.domain.tracing.DataCollectedEvent::class.java,
      "Tethering.accepted" to pl.wendigo.chrome.domain.tethering.AcceptedEvent::class.java,
      "Profiler.consoleProfileFinished" to pl.wendigo.chrome.domain.profiler.ConsoleProfileFinishedEvent::class.java,
      "Page.colorPicked" to pl.wendigo.chrome.domain.page.ColorPickedEvent::class.java,
      "Emulation.virtualTimeBudgetExpired" to pl.wendigo.chrome.ChromeProtocolEvent::class.java,
      "Network.responseReceived" to pl.wendigo.chrome.domain.network.ResponseReceivedEvent::class.java,
      "Network.dataReceived" to pl.wendigo.chrome.domain.network.DataReceivedEvent::class.java,
      "ApplicationCache.applicationCacheStatusUpdated" to pl.wendigo.chrome.domain.applicationcache.ApplicationCacheStatusUpdatedEvent::class.java,
      "DOM.documentUpdated" to pl.wendigo.chrome.ChromeProtocolEvent::class.java,
      "Runtime.exceptionThrown" to pl.wendigo.chrome.domain.runtime.ExceptionThrownEvent::class.java,
      "Page.loadEventFired" to pl.wendigo.chrome.domain.page.LoadEventFiredEvent::class.java,
      "Page.frameScheduledNavigation" to pl.wendigo.chrome.domain.page.FrameScheduledNavigationEvent::class.java,
      "Page.javascriptDialogOpening" to pl.wendigo.chrome.domain.page.JavascriptDialogOpeningEvent::class.java,
      "DOMStorage.domStorageItemAdded" to pl.wendigo.chrome.domain.domstorage.DomStorageItemAddedEvent::class.java,
      "ApplicationCache.networkStateUpdated" to pl.wendigo.chrome.domain.applicationcache.NetworkStateUpdatedEvent::class.java,
      "CSS.mediaQueryResultChanged" to pl.wendigo.chrome.ChromeProtocolEvent::class.java,
      "LayerTree.layerTreeDidChange" to pl.wendigo.chrome.domain.layertree.LayerTreeDidChangeEvent::class.java,
      "Runtime.executionContextDestroyed" to pl.wendigo.chrome.domain.runtime.ExecutionContextDestroyedEvent::class.java,
      "Page.frameAttached" to pl.wendigo.chrome.domain.page.FrameAttachedEvent::class.java,
      "HeapProfiler.heapStatsUpdate" to pl.wendigo.chrome.domain.heapprofiler.HeapStatsUpdateEvent::class.java,
      "Debugger.scriptFailedToParse" to pl.wendigo.chrome.domain.debugger.ScriptFailedToParseEvent::class.java,
      "Network.loadingFailed" to pl.wendigo.chrome.domain.network.LoadingFailedEvent::class.java,
      "DOM.childNodeInserted" to pl.wendigo.chrome.domain.dom.ChildNodeInsertedEvent::class.java,
      "ServiceWorker.workerErrorReported" to pl.wendigo.chrome.domain.serviceworker.WorkerErrorReportedEvent::class.java,
      "Tracing.bufferUsage" to pl.wendigo.chrome.domain.tracing.BufferUsageEvent::class.java,
      "Network.resourceChangedPriority" to pl.wendigo.chrome.domain.network.ResourceChangedPriorityEvent::class.java,
      "DOM.inspectNodeRequested" to pl.wendigo.chrome.domain.dom.InspectNodeRequestedEvent::class.java,
      "DOM.pseudoElementAdded" to pl.wendigo.chrome.domain.dom.PseudoElementAddedEvent::class.java,
      "Animation.animationCreated" to pl.wendigo.chrome.domain.animation.AnimationCreatedEvent::class.java,
      "Animation.animationStarted" to pl.wendigo.chrome.domain.animation.AnimationStartedEvent::class.java,
      "DOMStorage.domStorageItemUpdated" to pl.wendigo.chrome.domain.domstorage.DomStorageItemUpdatedEvent::class.java,
      "Page.frameStartedLoading" to pl.wendigo.chrome.domain.page.FrameStartedLoadingEvent::class.java,
      "Network.loadingFinished" to pl.wendigo.chrome.domain.network.LoadingFinishedEvent::class.java,
      "Network.webSocketClosed" to pl.wendigo.chrome.domain.network.WebSocketClosedEvent::class.java,
      "Profiler.consoleProfileStarted" to pl.wendigo.chrome.domain.profiler.ConsoleProfileStartedEvent::class.java,
      "Page.frameDetached" to pl.wendigo.chrome.domain.page.FrameDetachedEvent::class.java,
      "Page.interstitialHidden" to pl.wendigo.chrome.ChromeProtocolEvent::class.java,
      "Network.webSocketFrameError" to pl.wendigo.chrome.domain.network.WebSocketFrameErrorEvent::class.java,
      "DOM.nodeHighlightRequested" to pl.wendigo.chrome.domain.dom.NodeHighlightRequestedEvent::class.java,
      "Target.targetCreated" to pl.wendigo.chrome.domain.target.TargetCreatedEvent::class.java,
      "Target.receivedMessageFromTarget" to pl.wendigo.chrome.domain.target.ReceivedMessageFromTargetEvent::class.java,
      "Tracing.tracingComplete" to pl.wendigo.chrome.domain.tracing.TracingCompleteEvent::class.java,
      "Runtime.executionContextsCleared" to pl.wendigo.chrome.ChromeProtocolEvent::class.java,
      "Page.domContentEventFired" to pl.wendigo.chrome.domain.page.DomContentEventFiredEvent::class.java,
      "HeapProfiler.resetProfiles" to pl.wendigo.chrome.ChromeProtocolEvent::class.java,
      "Console.messageAdded" to pl.wendigo.chrome.domain.console.MessageAddedEvent::class.java
      ))
    }

    /**
     * Returns Inspector domain object.
     */
    val Inspector : pl.wendigo.chrome.domain.inspector.InspectorDomain by lazy {
        pl.wendigo.chrome.domain.inspector.InspectorDomain(api)
    }

    /**
     * Returns Memory domain object.
     */
    val Memory : pl.wendigo.chrome.domain.memory.MemoryDomain by lazy {
        pl.wendigo.chrome.domain.memory.MemoryDomain(api)
    }

    /**
     * Actions and events related to the inspected page belong to the page domain.
     */
    val Page : pl.wendigo.chrome.domain.page.PageDomain by lazy {
        pl.wendigo.chrome.domain.page.PageDomain(api)
    }

    /**
     * This domain allows to control rendering of the page.
     */
    val Rendering : pl.wendigo.chrome.domain.rendering.RenderingDomain by lazy {
        pl.wendigo.chrome.domain.rendering.RenderingDomain(api)
    }

    /**
     * This domain emulates different environments for the page.
     */
    val Emulation : pl.wendigo.chrome.domain.emulation.EmulationDomain by lazy {
        pl.wendigo.chrome.domain.emulation.EmulationDomain(api)
    }

    /**
     * Security
     */
    val Security : pl.wendigo.chrome.domain.security.SecurityDomain by lazy {
        pl.wendigo.chrome.domain.security.SecurityDomain(api)
    }

    /**
     * Network domain allows tracking network activities of the page. It exposes information about http, file, data and other requests and responses, their headers, bodies, timing, etc.
     */
    val Network : pl.wendigo.chrome.domain.network.NetworkDomain by lazy {
        pl.wendigo.chrome.domain.network.NetworkDomain(api)
    }

    /**
     * Returns Database domain object.
     */
    val Database : pl.wendigo.chrome.domain.database.DatabaseDomain by lazy {
        pl.wendigo.chrome.domain.database.DatabaseDomain(api)
    }

    /**
     * Returns IndexedDB domain object.
     */
    val IndexedDB : pl.wendigo.chrome.domain.indexeddb.IndexedDBDomain by lazy {
        pl.wendigo.chrome.domain.indexeddb.IndexedDBDomain(api)
    }

    /**
     * Returns CacheStorage domain object.
     */
    val CacheStorage : pl.wendigo.chrome.domain.cachestorage.CacheStorageDomain by lazy {
        pl.wendigo.chrome.domain.cachestorage.CacheStorageDomain(api)
    }

    /**
     * Query and modify DOM storage.
     */
    val DOMStorage : pl.wendigo.chrome.domain.domstorage.DOMStorageDomain by lazy {
        pl.wendigo.chrome.domain.domstorage.DOMStorageDomain(api)
    }

    /**
     * Returns ApplicationCache domain object.
     */
    val ApplicationCache : pl.wendigo.chrome.domain.applicationcache.ApplicationCacheDomain by lazy {
        pl.wendigo.chrome.domain.applicationcache.ApplicationCacheDomain(api)
    }

    /**
     * This domain exposes DOM read/write operations. Each DOM Node is represented with its mirror object that has an <code>id</code>. This <code>id</code> can be used to get additional information on the Node, resolve it into the JavaScript object wrapper, etc. It is important that client receives DOM events only for the nodes that are known to the client. Backend keeps track of the nodes that were sent to the client and never sends the same node twice. It is client's responsibility to collect information about the nodes that were sent to the client.<p>Note that <code>iframe</code> owner elements will return corresponding document elements as their child nodes.</p>
     */
    val DOM : pl.wendigo.chrome.domain.dom.DOMDomain by lazy {
        pl.wendigo.chrome.domain.dom.DOMDomain(api)
    }

    /**
     * This domain exposes CSS read/write operations. All CSS objects (stylesheets, rules, and styles) have an associated <code>id</code> used in subsequent operations on the related object. Each object type has a specific <code>id</code> structure, and those are not interchangeable between objects of different kinds. CSS objects can be loaded using the <code>get*ForNode()</code> calls (which accept a DOM node id). A client can also discover all the existing stylesheets with the <code>getAllStyleSheets()</code> method (or keeping track of the <code>styleSheetAdded</code>/<code>styleSheetRemoved</code> events) and subsequently load the required stylesheet contents using the <code>getStyleSheet[Text]()</code> methods.
     */
    val CSS : pl.wendigo.chrome.domain.css.CSSDomain by lazy {
        pl.wendigo.chrome.domain.css.CSSDomain(api)
    }

    /**
     * Input/Output operations for streams produced by DevTools.
     */
    val IO : pl.wendigo.chrome.domain.io.IODomain by lazy {
        pl.wendigo.chrome.domain.io.IODomain(api)
    }

    /**
     * DOM debugging allows setting breakpoints on particular DOM operations and events. JavaScript execution will stop on these operations as if there was a regular breakpoint set.
     */
    val DOMDebugger : pl.wendigo.chrome.domain.domdebugger.DOMDebuggerDomain by lazy {
        pl.wendigo.chrome.domain.domdebugger.DOMDebuggerDomain(api)
    }

    /**
     * Supports additional targets discovery and allows to attach to them.
     */
    val Target : pl.wendigo.chrome.domain.target.TargetDomain by lazy {
        pl.wendigo.chrome.domain.target.TargetDomain(api)
    }

    /**
     * Returns ServiceWorker domain object.
     */
    val ServiceWorker : pl.wendigo.chrome.domain.serviceworker.ServiceWorkerDomain by lazy {
        pl.wendigo.chrome.domain.serviceworker.ServiceWorkerDomain(api)
    }

    /**
     * Returns Input domain object.
     */
    val Input : pl.wendigo.chrome.domain.input.InputDomain by lazy {
        pl.wendigo.chrome.domain.input.InputDomain(api)
    }

    /**
     * Returns LayerTree domain object.
     */
    val LayerTree : pl.wendigo.chrome.domain.layertree.LayerTreeDomain by lazy {
        pl.wendigo.chrome.domain.layertree.LayerTreeDomain(api)
    }

    /**
     * Returns DeviceOrientation domain object.
     */
    val DeviceOrientation : pl.wendigo.chrome.domain.deviceorientation.DeviceOrientationDomain by lazy {
        pl.wendigo.chrome.domain.deviceorientation.DeviceOrientationDomain(api)
    }

    /**
     * Returns Tracing domain object.
     */
    val Tracing : pl.wendigo.chrome.domain.tracing.TracingDomain by lazy {
        pl.wendigo.chrome.domain.tracing.TracingDomain(api)
    }

    /**
     * Returns Animation domain object.
     */
    val Animation : pl.wendigo.chrome.domain.animation.AnimationDomain by lazy {
        pl.wendigo.chrome.domain.animation.AnimationDomain(api)
    }

    /**
     * Returns Accessibility domain object.
     */
    val Accessibility : pl.wendigo.chrome.domain.accessibility.AccessibilityDomain by lazy {
        pl.wendigo.chrome.domain.accessibility.AccessibilityDomain(api)
    }

    /**
     * Returns Storage domain object.
     */
    val Storage : pl.wendigo.chrome.domain.storage.StorageDomain by lazy {
        pl.wendigo.chrome.domain.storage.StorageDomain(api)
    }

    /**
     * Provides access to log entries.
     */
    val Log : pl.wendigo.chrome.domain.log.LogDomain by lazy {
        pl.wendigo.chrome.domain.log.LogDomain(api)
    }

    /**
     * The SystemInfo domain defines methods and events for querying low-level system information.
     */
    val SystemInfo : pl.wendigo.chrome.domain.systeminfo.SystemInfoDomain by lazy {
        pl.wendigo.chrome.domain.systeminfo.SystemInfoDomain(api)
    }

    /**
     * The Tethering domain defines methods and events for browser port binding.
     */
    val Tethering : pl.wendigo.chrome.domain.tethering.TetheringDomain by lazy {
        pl.wendigo.chrome.domain.tethering.TetheringDomain(api)
    }

    /**
     * Provides information about the protocol schema.
     */
    val Schema : pl.wendigo.chrome.domain.schema.SchemaDomain by lazy {
        pl.wendigo.chrome.domain.schema.SchemaDomain(api)
    }

    /**
     * Runtime domain exposes JavaScript runtime by means of remote evaluation and mirror objects. Evaluation results are returned as mirror object that expose object type, string representation and unique identifier that can be used for further object reference. Original objects are maintained in memory unless they are either explicitly released or are released along with the other objects in their object group.
     */
    val Runtime : pl.wendigo.chrome.domain.runtime.RuntimeDomain by lazy {
        pl.wendigo.chrome.domain.runtime.RuntimeDomain(api)
    }

    /**
     * Debugger domain exposes JavaScript debugging capabilities. It allows setting and removing breakpoints, stepping through execution, exploring stack traces, etc.
     */
    val Debugger : pl.wendigo.chrome.domain.debugger.DebuggerDomain by lazy {
        pl.wendigo.chrome.domain.debugger.DebuggerDomain(api)
    }

    /**
     * This domain is deprecated - use Runtime or Log instead.
     */
    val Console : pl.wendigo.chrome.domain.console.ConsoleDomain by lazy {
        pl.wendigo.chrome.domain.console.ConsoleDomain(api)
    }

    /**
     * Returns Profiler domain object.
     */
    val Profiler : pl.wendigo.chrome.domain.profiler.ProfilerDomain by lazy {
        pl.wendigo.chrome.domain.profiler.ProfilerDomain(api)
    }

    /**
     * Returns HeapProfiler domain object.
     */
    val HeapProfiler : pl.wendigo.chrome.domain.heapprofiler.HeapProfilerDomain by lazy {
        pl.wendigo.chrome.domain.heapprofiler.HeapProfilerDomain(api)
    }


    /**
     * Closes connection to API.
     */
    fun Close() {
      return api.close()
    }

    companion object {
        /**
         * Connects to chrome debugging protocol on host and port.
         */
        @kotlin.jvm.Throws(RemoteChromeException::class)
        fun connect(host: String, port: Int, debug: Boolean) : RemoteChrome {
          return RemoteChrome(
              RemoteChromeConnection(host, port, debug).connect()
          )
        }
    }
}