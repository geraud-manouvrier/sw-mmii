/**
 * Kendo UI v2023.1.314 (http://www.telerik.com/kendo-ui)
 * Copyright 2023 Progress Software Corporation and/or one of its subsidiaries or affiliates. All rights reserved.
 *
 * Kendo UI commercial licenses may be obtained at
 * http://www.telerik.com/purchase/license-agreement/kendo-ui-complete
 * If you do not own a commercial license, this file shall be governed by the trial license terms.
 */
import"./kendo.core.js";import"./kendo.button.js";var __meta__={id:"togglebutton",name:"ToggleButton",category:"web",description:"The ToggleButton widget displays styled buttons with selected state.",depends:["core","button"]};!function(e,t){var o=window.kendo,s=o.ui.Button,i="click",n="toggle",l="aria-pressed",r="k-selected",d=s.extend({init:function(e,t){var i=this;s.fn.init.call(i,e,t),e=i.wrapper=i.element,t=i.options,e.addClass("k-toggle-button"),i._selected=!0===t.selected,i.toggle(i._selected),t.group&&e.attr("data-group",t.group),o.notify(i)},destroy:function(){this.wrapper.off(".kendoToggleButton"),s.fn.destroy.call(this)},events:[i,n],options:{name:"ToggleButton",group:t,selected:!1},toggle:function(e){e===t&&(e=!this._selected),this._selected=e,!0===e?(this.element.attr(l,!0),this.element.addClass(r)):!1===e&&(this.element.attr(l,!1),this.element.removeClass(r))},_click:function(e){this.options.enable&&(this.trigger(i,{event:e,id:this.element.attr("id"),target:this.element})?e.preventDefault():(this.toggle(),this.trigger(n,{event:e,checked:this._selected,group:this.options.group,id:this.element.attr("id"),target:this.element})))}});o.cssProperties.registerPrefix("ToggleButton","k-button-"),o.cssProperties.registerValues("ToggleButton",[{prop:"fillMode",values:o.cssProperties.fillModeValues.concat(["link"])},{prop:"rounded",values:o.cssProperties.roundedValues.concat([["full","full"]])}]),o.ui.plugin(d)}(window.kendo.jQuery);
//# sourceMappingURL=kendo.togglebutton.js.map
