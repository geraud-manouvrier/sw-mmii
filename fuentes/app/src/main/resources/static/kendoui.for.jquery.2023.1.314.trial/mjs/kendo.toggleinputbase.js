/**
 * Kendo UI v2023.1.314 (http://www.telerik.com/kendo-ui)
 * Copyright 2023 Progress Software Corporation and/or one of its subsidiaries or affiliates. All rights reserved.
 *
 * Kendo UI commercial licenses may be obtained at
 * http://www.telerik.com/purchase/license-agreement/kendo-ui-complete
 * If you do not own a commercial license, this file shall be governed by the trial license terms.
 */
import"./kendo.core.js";var __meta__={id:"toggleinputbase",name:"ToggleInputBase",category:"web",description:"The ToggleInputBase component.",depends:["core"]};!function(e,n){var t=window.kendo,i=t.ui,c=i.Widget,o="change",a="disabled",s="checked",d=c.extend({init:function(e,n){var i=this;c.fn.init.call(i,e,n),i._wrapper(),i._initSettings(),i._attachEvents(),t.notify(i,t.ui)},events:[o],options:{name:"ToggleInputBase"},NS:".kendoToggleInputBase",RENDER_INPUT:e.noop,check:function(e){var n=this,t=n.element[0];if(undefined===e)return t.checked;t.checked!==e&&(n.options.checked=t.checked=e),e?n.element.attr(s,s):n.element.prop(s,!1)},destroy:function(){c.fn.destroy.call(this),this.wrapper.off(this.NS)},enable:function(e){var n=this.element;void 0===e&&(e=!0),this.options.enabled=e,e?n.prop(a,!1):n.attr(a,a)},toggle:function(){this.check(!this.element[0].checked)},_attachEvents:function(){this.element.on(o+this.NS,this._change.bind(this))},_change:function(){var e=this.element[0].checked;this.trigger(o,{checked:e})},_initSettings:function(){var e=this,n=e.element[0],t=e.options;null===t.checked&&(t.checked=n.checked),e.check(t.checked),t.enabled=t.enabled&&!e.element.attr(a),e.enable(t.enabled)},_wrapper:function(){var n=this,t=n.options;(0,n.RENDER_INPUT)(n.element,e.extend({},t)),n.element.removeClass("input-validation-error"),n.wrapper=n.element}});i.plugin(d)}(window.kendo.jQuery);
//# sourceMappingURL=kendo.toggleinputbase.js.map
