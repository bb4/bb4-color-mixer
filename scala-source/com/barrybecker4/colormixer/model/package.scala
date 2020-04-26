package com.barrybecker4.colormixer

import java.awt.AlphaComposite

import com.barrybecker4.common.app.AppContext


package object model {

  val porterDuffRules: Array[PorterDuffRule] = Array(
    PorterDuffRule(AppContext.getLabel("DEST_ATOP_SRC"),
      AppContext.getLabel("DEST_ATOP_SRC_DESC"),
      AlphaComposite.DST_ATOP),

    PorterDuffRule("Destination Atop Source",
      "The part of the destination lying inside of the source is composited over the source and replaces the destination",
      AlphaComposite.DST_ATOP),
    PorterDuffRule("Destination In Source",
      "The part of the destination lying inside of the source replaces the destination",
      AlphaComposite.DST_IN),
    PorterDuffRule("Destination Held Out By Source",
      "The part of the destination lying outside of the source replaces the destination",
      AlphaComposite.DST_OUT),
    PorterDuffRule("Destination Over Source",
      "The destination is composited over the source and the result replaces the destination",
      AlphaComposite.DST_OVER),
    PorterDuffRule("Source Atop Destination",
      "The part of the source lying inside of the destination is composited onto the destination",
      AlphaComposite.SRC_ATOP),
    PorterDuffRule("Source In Destination",
      "The part of the source lying inside of the destination replaces the destination",
      AlphaComposite.SRC_IN),
    PorterDuffRule("Source Held Out By Destination",
      "The part of the source lying outside of the destination replaces the destination",
      AlphaComposite.SRC_OUT),
    PorterDuffRule("Source Over Destination",
      "The source is composited over the destination",
      AlphaComposite.SRC_OVER),
    PorterDuffRule("Clear",
      "Both the color and the alpha of the destination are cleared. " +
        "Neither the source nor the destination is used as input.",
      AlphaComposite.CLEAR),
    PorterDuffRule("Source XOR Destination",
      "The part of the source that lies outside of the destination is combined " +
        "with the part of the destination that lies outside of the source",
      AlphaComposite.XOR),
  )
}
