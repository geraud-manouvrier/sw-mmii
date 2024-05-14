/**
 * Kendo UI v2023.1.314 (http://www.telerik.com/kendo-ui)
 * Copyright 2023 Progress Software Corporation and/or one of its subsidiaries or affiliates. All rights reserved.
 *
 * Kendo UI commercial licenses may be obtained at
 * http://www.telerik.com/purchase/license-agreement/kendo-ui-complete
 * If you do not own a commercial license, this file shall be governed by the trial license terms.
 */
import"./kendo.html.base.js";import"./kendo.icons.js";var __meta__={id:"html.chip",name:"Html.Chip",category:"web",description:"HTML rendering utility for Kendo UI for jQuery.",depends:["html.base","icons"],features:[]};!function(e,a){var t=window.kendo,s=t.html.HTMLBase,n=s.extend({init:function(e,a){s.fn.init.call(this,e,a),this._wrapper()},options:{name:"HTMLChip",size:"medium",rounded:"medium",fillMode:"solid",themeColor:"base",attr:{},icon:"",iconClass:"",iconAttr:{},removable:!1,removableAttr:{},removeIcon:"x-circle",removeIconClass:"",content:"",text:"",stylingOptions:["size","rounded","fillMode","themeColor"]},_wrapper:function(){var a=this,s=a.options;s.text=s.text||s.label,a.wrapper=a.element.wrap("<div class='k-chip'></div>").parent().attr(s.attr),a._addClasses(),s.icon?a.wrapper.prepend(e(t.ui.icon({icon:s.icon,iconClass:"k-chip-icon"+(s.iconClass?` ${s.iconClass}`:"")})).attr(s.iconAttr)):s.iconClass?a.wrapper.prepend(e("<span class='"+s.iconClass+"'></span>").attr(s.iconAttr)):s.avatarClass&&a.wrapper.prepend(e("<span class='k-chip-avatar k-avatar "+s.avatarClass+"'></span>").attr(s.iconAttr)),a.element.addClass("k-chip-content"),s.text&&a.element.html('<span class="k-chip-label">'+s.text+"</span>"),!1===s.visible&&a.wrapper.addClass("k-hidden"),!0===s.selected&&a.wrapper.addClass("k-selected"),!1===s.enabled&&a.wrapper.addClass("k-disabled"),s.removable&&a.wrapper.append(e(`<span class='k-chip-action k-chip-remove-action'>${t.ui.icon({icon:s.removeIcon,iconClass:"k-chip-icon"})}</span>`).attr(s.removableAttr))}});e.extend(t.html,{renderChip:function(a,t){return a&&!e.isPlainObject(a)||(t=a,a=e("<span></span>")),new n(a,t).html()},HTMLChip:n}),t.cssProperties.registerPrefix("HTMLChip","k-chip-"),t.cssProperties.registerValues("HTMLChip",[{prop:"rounded",values:t.cssProperties.roundedValues.concat([["full","full"]])}])}(window.kendo.jQuery);
//# sourceMappingURL=kendo.html.chip.js.map
