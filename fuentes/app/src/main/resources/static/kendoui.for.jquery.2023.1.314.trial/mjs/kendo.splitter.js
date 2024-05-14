/**
 * Kendo UI v2023.1.314 (http://www.telerik.com/kendo-ui)
 * Copyright 2023 Progress Software Corporation and/or one of its subsidiaries or affiliates. All rights reserved.
 *
 * Kendo UI commercial licenses may be obtained at
 * http://www.telerik.com/purchase/license-agreement/kendo-ui-complete
 * If you do not own a commercial license, this file shall be governed by the trial license terms.
 */
import"./kendo.resizable.js";import"./kendo.icons.js";var __meta__={id:"splitter",name:"Splitter",category:"web",description:"The Splitter widget provides an easy way to create a dynamic layout of resizable and collapsible panes.",depends:["resizable","icons"]};!function(e,t){var n=window.kendo,i=n.ui,r=n.keys,a=e.extend,s=i.Widget,o=/^\d+(\.\d+)?px$/i,l=/^\d+(\.\d+)?%$/i,p=".kendoSplitter",d="expand",c="collapse",h="contentLoad",u="error",g="layoutChange",f="horizontal",v="vertical",m="click",_="pane",k="k-focus",b="k-pane",z=".k-pane";function y(e){return l.test(e)}function x(e){return o.test(e)||/^\d+$/.test(e)}function w(e){return!y(e)&&!x(e)}function P(e,t){var n=parseInt(e,10);return y(e)&&(n=Math.floor(n*t/100)),n}function C(e,t){return function(n,i){var r=this.element.find(n).data(_);if(1==arguments.length)return r[e];if(r[e]=i,t){var a=this.element.data("kendo"+this.options.name);a.resize(!0)}}}var S=s.extend({init:function(e,t){var i,a=this;s.fn.init.call(a,e,t),a.wrapper=a.element,a.options.orientation&&(i=a.options.orientation.toLowerCase()!=v),a.orientation=i?f:v,a._dimension=i?"width":"height",a._keys={decrease:i?r.LEFT:r.UP,increase:i?r.RIGHT:r.DOWN},a._resizeStep=10,a._marker=n.guid().substring(0,8),a._initPanes(),a.resizing=new E(a),a.element.triggerHandler("init"+p)},events:[d,c,h,u,"resize",g],_addOverlays:function(){this._panes().append("<div class='k-splitter-overlay k-overlay' />")},_removeOverlays:function(){this._panes().children(".k-splitter-overlay").remove()},_attachEvents:function(){var t=this,n=t.options.orientation;t.element.children(".k-splitbar-draggable-"+n).on("keydown"+p,t._keydown.bind(t)).on("mousedown"+p,(function(e){e.currentTarget.focus()})).on("focus"+p,(function(t){e(t.currentTarget).addClass(k)})).on("blur"+p,(function(n){e(n.currentTarget).removeClass(k),t.resizing&&t.resizing.end()})).on("mouseenter"+p,(function(){e(this).addClass("k-splitbar-"+t.orientation+"-hover")})).on("mouseleave"+p,(function(){e(this).removeClass("k-splitbar-"+t.orientation+"-hover")})).on("mousedown"+p,t._addOverlays.bind(t)).end().children(".k-splitbar").on("dblclick"+p,t._togglePane.bind(t)).children(".k-collapse-next, .k-collapse-prev").on(m+p,t._arrowClick(c)).end().children(".k-expand-next, .k-expand-prev").on(m+p,t._arrowClick(d)).end().end(),e(window).on("resize"+p+t._marker,t.resize.bind(t,!1)),e(document).on("mouseup"+p+t._marker,t._removeOverlays.bind(t))},_detachEvents:function(){var t=this;t.element.children(".k-splitbar-draggable-"+t.orientation).off(p).end().children(".k-splitbar").off("dblclick"+p).children(".k-collapse-next, .k-collapse-prev, .k-expand-next, .k-expand-prev").off(p),e(window).off(p+t._marker),e(document).off(p+t._marker)},options:{name:"Splitter",orientation:f,panes:[]},destroy:function(){s.fn.destroy.call(this),this._detachEvents(),this.resizing&&this.resizing.destroy(),n.destroy(this.element),this.wrapper=this.element=null},_keydown:function(t){var n,i=this,a=t.keyCode,s=i.resizing,o=e(t.currentTarget),l=i._keys,p=a===l.increase,h=a===l.decrease;p||h?(t.ctrlKey?(n=o[h?"next":"prev"](),s&&s.isResizing()&&s.end(),n[i._dimension]()?i._triggerAction(c,o[h?"prev":"next"]()):i._triggerAction(d,n)):s&&s.move((h?-1:1)*i._resizeStep,o),t.preventDefault()):a===r.HOME?(n=o.prev(),i.collapse(n),t.preventDefault()):a===r.END?(n=o.prev(),i.expand(n),t.preventDefault()):a===r.ENTER&&s&&(s.end(),t.preventDefault())},_initPanes:function(){var e=this.options.panes||[],t=this;this.element.addClass("k-widget").addClass("k-splitter").children().each((function(n,i){"script"!=i.nodeName.toLowerCase()&&t._initPane(i,e[n])})),this.resize()},_initPane:function(t,n){(t=e(t).attr("role","group").addClass(b)).data(_,n||{}).toggleClass("k-scrollable",!n||!1!==n.scrollable),this.ajaxRequest(t)},ajaxRequest:function(e,t,i){var r,a=this;r=(e=a.element.find(e)).data(_),(t=t||r.contentUrl)&&(e.append("<span class='k-icon k-i-loading k-pane-loading' />"),n.isLocalUrl(t)?jQuery.ajax({url:t,data:i||{},type:"GET",dataType:"html",success:function(t){a.angular("cleanup",(function(){return{elements:e.get()}})),e.html(t),a.angular("compile",(function(){return{elements:e.get()}})),a.trigger(h,{pane:e[0]})},error:function(t,n){a.trigger(u,{pane:e[0],status:n,xhr:t})}}):e.removeClass("k-scrollable").html("<iframe src='"+t+"' frameborder='0' class='k-content-frame'>This page requires frames in order to show content</iframe>"))},_triggerAction:function(e,t){var n=t.data(_),i=n.collapsed&&e==d||!n.collapsed&&e==c;n.collapsible&&i&&!this.trigger(e,{pane:t[0]})&&this[e](t[0])},_togglePane:function(t){var n,i=this,r=e(t.target);r.closest(".k-splitter")[0]==i.element[0]&&1===(n=r.children("span:not(.k-resize-handle)")).length&&(n.is(".k-collapse-prev")?i._triggerAction(c,r.prev()):n.is(".k-collapse-next")?i._triggerAction(c,r.next()):n.is(".k-expand-prev")?i._triggerAction(d,r.prev()):n.is(".k-expand-next")&&i._triggerAction(d,r.next()))},_arrowClick:function(t){var n=this;return function(i){var r,a=e(i.currentTarget);a.closest(".k-splitter")[0]==n.element[0]&&(r=a.is(".k-"+t+"-prev")?a.parent().prev():a.parent().next(),n._triggerAction(t,r))}},_updateSplitBar:function(e,t,r,a){var s=function(e,t,n){var r=t?i.icon(t):"";return n?"<span class='k-"+e+"'>"+r+"</span>":""},o=this.orientation,l=!1!==t.resizable&&!1!==r.resizable,p=t.collapsible,d=t.collapsed,c=r.collapsible,h=r.collapsed,u=a.attr("id");u||(u=n.guid(),a.attr("id",u)),e.addClass("k-splitbar k-splitbar-"+o).attr("role","separator").attr("aria-valuemin","0").attr("aria-valuemax","100").attr("aria-controls",u).removeClass("k-splitbar-"+o+"-hover").toggleClass("k-splitbar-draggable-"+o,l&&!d&&!h).toggleClass("k-splitbar-static-"+o,!l&&!p&&!c).html(s("collapse-prev","caret-alt-up",p&&!d&&!h&&o==v)+s("collapse-prev","caret-alt-left",p&&!d&&!h&&o==f)+s("expand-prev","caret-alt-down",p&&d&&!h&&o==v)+s("expand-prev","caret-alt-right",p&&d&&!h&&o==f)+s("resize-handle",null,l&&o==v)+s("resize-handle",null,l&&o==f)+s("collapse-next","caret-alt-down",c&&!h&&!d&&o==v)+s("collapse-next","caret-alt-right",c&&!h&&!d&&o==f)+s("expand-next","caret-alt-up",c&&h&&!d&&o==v)+s("expand-next","caret-alt-left",c&&h&&!d&&o==f)),t.labelId?e.attr("aria-labelledby",t.labelId):t.label&&e.attr("aria-label",t.label),o==f&&e.attr("aria-orientation",v),l||p||c||e.removeAttr("tabindex")},_updateSplitBars:function(){var t=this;this.element.children(".k-splitbar").each((function(){var n=e(this),i=n.prevAll(z).first(),r=i.data(_),a=n.nextAll(z).first().data(_);a&&t._updateSplitBar(n,r,a,i)}))},_removeSplitBars:function(){this.element.children(".k-splitbar").remove()},_panes:function(){return this.element?this.element.children(z):e()},_resetAriaValueNow:function(e,t){var n,i,r;for(n=0;n<e.length;n++)r=t[n]+t[n+1]||1,i=Math.round(t[n]/r*100),e[n].setAttribute("aria-valuenow",i)},_resize:function(){var t=this,i=t.element,r=i.children(z),a=t.orientation==f,s=i.children(".k-splitbar"),o=s.length,l=a?"width":"height",p=i[l](),d=[];t.wrapper.addClass("k-splitter-resizing"),0===o?(o=r.length-1,r.slice(0,o).after("<div tabindex='0' class='k-splitbar' data-marker='"+t._marker+"' />"),t._updateSplitBars(),s=i.children(".k-splitbar")):t._updateSplitBars(),s.each((function(){p-=this[a?"offsetWidth":"offsetHeight"]}));var c=0,h=e();r.css({position:"absolute",top:0})[l]((function(){var t,n=e(this),i=n.data(_)||{};if(n.removeClass("k-collapsed"),i.collapsed)t=i.collapsedSize?P(i.collapsedSize,p):0,n.css("overflow","hidden").addClass("k-collapsed");else{if(w(i.size))return h=h.add(this),void d.push(!1);t=P(i.size,p)}return c+=t,d.push(t),t})),p-=c;var u=h.length,v=Math.floor(p/u);h.slice(0,u-1).css(l,v).end().eq(u-1).css(l,p-(u-1)*v),d.forEach((function(e,t){!1===e&&(d[t]=v)})),t._resetAriaValueNow(s,d);var m=0,k=a?"height":"width",b=a?"left":"top",y=a?"offsetWidth":"offsetHeight";if(0===u){var x=r.filter((function(){return!(e(this).data(_)||{}).collapsed})).last();x[l](p+x[0][y])}i.children().css(k,i[k]()).each((function(e,t){"script"!=t.tagName.toLowerCase()&&(t.style[b]=Math.floor(m)+"px",m+=t[y])})),t._detachEvents(),t._attachEvents(),t.wrapper.removeClass("k-splitter-resizing"),n.resize(r),t.trigger(g)},toggle:function(e,n){var i,r=this;i=(e=r.element.find(e)).data(_),(n||i.collapsible)&&(1==arguments.length&&(n=i.collapsed!==t&&i.collapsed),i.collapsed=!n,i.collapsed?e.css("overflow","hidden"):e.css("overflow",""),r.resize(!0))},collapse:function(e){this.toggle(e,!1)},expand:function(e){this.toggle(e,!0)},_addPane:function(e,t,n){var i=this;return n.length&&(i.options.panes.splice(t,0,e),i._initPane(n,e),i._removeSplitBars(),i.resize(!0)),n},append:function(t){t=t||{};var n=this,i=e("<div />").appendTo(n.element);return n._addPane(t,n.options.panes.length,i)},insertBefore:function(t,n){n=e(n),t=t||{};var i=this.wrapper.children(".k-pane").index(n),r=e("<div />").insertBefore(e(n));return this._addPane(t,i,r)},insertAfter:function(t,n){n=e(n),t=t||{};var i=this.wrapper.children(".k-pane").index(n),r=e("<div />").insertAfter(e(n));return this._addPane(t,i+1,r)},remove:function(t){var i=this;return(t=i.wrapper.find(t)).length&&(n.destroy(t),t.each((function(t,n){i.options.panes.splice(i.wrapper.children(".k-pane").index(n),1),e(n).remove()})),i._removeSplitBars(),i.options.panes.length&&i.resize(!0)),i},size:C("size",!0),min:C("min"),max:C("max")});i.plugin(S);var A={sizingProperty:"height",sizingDomProperty:"offsetHeight",alternateSizingProperty:"width",positioningProperty:"top",mousePositioningProperty:"pageY"},T={sizingProperty:"width",sizingDomProperty:"offsetWidth",alternateSizingProperty:"height",positioningProperty:"left",mousePositioningProperty:"pageX"};function E(e){var t=this,i=e.orientation;t.owner=e,t._element=e.element,t.orientation=i,a(t,i===f?T:A),t._resizable=new n.ui.Resizable(e.element,{orientation:i,handle:".k-splitbar-draggable-"+i+"[data-marker="+e._marker+"]",hint:t._createHint.bind(t),start:t._start.bind(t),max:t._max.bind(t),min:t._min.bind(t),invalidClass:"k-restricted-size-"+i,resizeend:t._stop.bind(t)})}E.prototype={press:function(e){this._resizable.press(e)},move:function(e,t){this.pressed||(this.press(t),this.pressed=!0),this._resizable.target||this._resizable.press(t),this._resizable.move(e)},end:function(){this._resizable.end(),this.pressed=!1},destroy:function(){this._resizable.destroy(),this._resizable=this._element=this.owner=null},isResizing:function(){return this._resizable.resizing},_createHint:function(t){var n=this;return e("<div class='k-ghost-splitbar k-ghost-splitbar-"+n.orientation+"' />").css(n.alternateSizingProperty,t[n.alternateSizingProperty]())},_start:function(t){var n=this,i=e(t.currentTarget),r=i.prev(),a=i.next(),s=r.data(_),o=a.data(_),l=parseInt(r[0].style[n.positioningProperty],10),p=parseInt(a[0].style[n.positioningProperty],10)+a[0][n.sizingDomProperty]-i[0][n.sizingDomProperty],d=parseInt(n._element.css(n.sizingProperty),10),c=function(e){var t=parseInt(e,10);return(x(e)?t:d*t/100)||0},h=c(s.min),u=c(s.max)||p-l,g=c(o.min),f=c(o.max)||p-l;n.previousPane=r,n.nextPane=a,n._maxPosition=Math.min(p-g,l+u),n._minPosition=Math.max(l+h,p-f)},_max:function(){return this._maxPosition},_min:function(){return this._minPosition},_stop:function(t){var i=this,r=e(t.currentTarget),a=i.owner;if(a._panes().children(".k-splitter-overlay").remove(),t.keyCode!==n.keys.ESC){var s=t.position,o=r.prev(),l=r.next(),p=o.data(_),d=l.data(_),c=s-parseInt(o[0].style[i.positioningProperty],10),h=parseInt(l[0].style[i.positioningProperty],10)+l[0][i.sizingDomProperty]-s-r[0][i.sizingDomProperty],u=i._element.children(z).filter((function(){return w(e(this).data(_).size)})).length;(!w(p.size)||u>1)&&(w(p.size)&&u--,p.size=c+"px"),(!w(d.size)||u>1)&&(d.size=h+"px"),a.resize(!0)}return!1}}}(window.kendo.jQuery);
//# sourceMappingURL=kendo.splitter.js.map
