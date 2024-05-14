/**
 * Kendo UI v2023.1.314 (http://www.telerik.com/kendo-ui)
 * Copyright 2023 Progress Software Corporation and/or one of its subsidiaries or affiliates. All rights reserved.
 *
 * Kendo UI commercial licenses may be obtained at
 * http://www.telerik.com/purchase/license-agreement/kendo-ui-complete
 * If you do not own a commercial license, this file shall be governed by the trial license terms.
 */
import"./kendo.html.button.js";import"./kendo.button.menu.js";var __meta__={id:"dropdownbutton",name:"DropDownButton",category:"web",description:"The DropDownButton allows the user to execute an action from a drop-down list.",depends:["button.menu","html.button"]};!function(e,t){var n=window.kendo,o=n.ui.Widget,i=".kendoDropDownButton",a=n.ui,l=n.keys,u=e.extend,r=n.html,s=n._outerWidth,d="aria-disabled",m="aria-label",p="aria-expanded",c="disabled",h="k-disabled",f="click",b="open",g="close",_="focus",v="k-menu-button",k="k-dropdown-button",w=o.extend({init:function(t,i){var a=this;i.enabled=!1!==i.enabled&&!e(t).prop(c),o.fn.init.call(a,t,i),a.wrapper=a.element,a._mainButton(),a._renderMenu(),a._enable(a.options.enabled),a._aria(),a._attachEvents(),n.notify(a),a._applyCssClasses()},options:{name:"DropDownButton",direction:"down",enabled:!0,items:[],rounded:"medium",size:"medium",fillMode:"solid",themeColor:"base",icon:null,popup:null,messages:{labelSuffix:"dropdownbutton"}},events:[f,b,g],_mainButton:function(){var e=this,t=u({},e.options,{type:e.element.attr("type")||"button"});delete t.click,e.element.addClass(v).addClass(k),r.renderButton(e.element,t)},_aria:function(){var e=this,t=e.element,n=e.menu;t.attr("aria-haspopup",n?"menu":null),t.attr(p,!n&&null),t.attr("aria-controls",n?n.list.attr("id"):null),t.attr(m)||t.attr(m,t.text()+" "+e.options.messages.labelSuffix)},_renderMenu:function(){var t=this,n=u({},t.options),o=e("<div></div>");delete n.click,delete n.name,n.items.length&&(t.menu=o.appendTo(document.body).kendoButtonMenu(u({mainButton:t.element,toggleTarget:t.element,menuOpen:t.menuOpenHandler.bind(t),menuClose:t.menuCloseHandler.bind(t),menuClick:t._click.bind(t)},n)).data("kendoButtonMenu"))},menuOpenHandler:function(e){var t=this,n=s(t.element);t.trigger(b,{target:t.element})?e.preventDefault():(e.sender.adjustPopupWidth(n),t.element.attr(p,!0))},menuCloseHandler:function(e){var t=this;t.trigger(g,{target:t.element})?e.preventDefault():(t.element.attr(p,!1),t.element.trigger(_))},_attachEvents:function(){var e=this;e.element.on("keydown"+i,e._keydown.bind(e))},_click:function(e){var t=e.id,n=e.target,o=e.originalEvent;this.menu.close(),this.trigger(f,{id:t,target:n,originalEvent:o})},_keydown:function(e){!this.element.is(".k-disabled")||e.keyCode!==l.ENTER&&e.keyCode!==l.SPACEBAR||e.preventDefault()},focus:function(){this.element.trigger(_)},_enable:function(e,t){this.element.toggleClass(h,!e),e?this.element.removeAttr(d):this.element.attr(d,!e),t||this.element.attr(c,!e)},enable:function(e,t,n){var o=this;undefined===e&&(e=!0),t&&t.length?o.menu.enable(e,t):(o.options.enabled=e,o._enable(e,n),o.menu.enable(e))},hide:function(e){e&&e.length&&this.menu.hide(e)},show:function(e){e&&e.length&&this.menu.show(e)},open:function(){this.menu._popup.open()},close:function(){this.menu._popup.close()},items:function(){return this.menu.items()},setOptions:function(e){var t=this;o.fn.setOptions.call(t,e),(e.popup||e.items||e.size)&&(t.menu.destroy(),t._renderMenu()),t._mainButton(),t._aria()},destroy:function(){var e=this;e.menu.destroy(),e.element.off(i),o.fn.destroy.call(e)}});a.plugin(w)}(window.kendo.jQuery);
//# sourceMappingURL=kendo.dropdownbutton.js.map
