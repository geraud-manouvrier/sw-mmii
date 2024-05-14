/**
 * Kendo UI v2023.1.314 (http://www.telerik.com/kendo-ui)
 * Copyright 2023 Progress Software Corporation and/or one of its subsidiaries or affiliates. All rights reserved.
 *
 * Kendo UI commercial licenses may be obtained at
 * http://www.telerik.com/purchase/license-agreement/kendo-ui-complete
 * If you do not own a commercial license, this file shall be governed by the trial license terms.
 */
import"./kendo.userevents.js";var __meta__={id:"drawer",name:"Drawer",category:"web",description:"The Kendo Drawer widget provides slide to reveal sidebar",depends:["userevents"]};!function(e,t){var i=window.kendo,r=i.ui.Widget,a=".kendoDrawer",n="k-focus",s=i.keys,d="push",o="overlay",h="left",l=i.ui.Widget.extend({init:function(t,a){var n,s=this;r.fn.init.call(this,t,a),a=s.options,s._element(t),s._wrapper(t),s._navigatable(),s.position(),s._mode(),a.mini&&s._miniMode(),s._initDrawerItems(),a.mini&&a.mode!=d&&s._setBodyOffset(),n=this.userEvents=new i.UserEvents(a.mode!=d?e(document.body):this.drawerContainer,{fastTap:!0,allowSelection:!0}),s.tap=function(t){e.contains(s.drawerItemsWrapper[0],t.event.target)&&s._itemClick(t),a.autoCollapse&&s.visible&&!s.trigger("hide",{sender:this})&&(s.hide(),t.preventDefault())},this.options.swipeToOpen?(n.bind("start",(function(e){s._start(e)})),n.bind("move",(function(e){s._update(e)})),n.bind("end",(function(e){s._end(e)})),n.bind("tap",s.tap)):n.bind("press",s.tap),a.minHeight&&a.mode==d&&s.drawerContainer.css("min-height",a.minHeight)},_element:function(){var t=this,i=t.element,r=t.options;t.contentElement=i.children().wrapAll("<div class='k-drawer-content'></div>").parent(),t.drawerElement=e(r.template),i.addClass("k-widget k-drawer")},_navigatable:function(){var e=this,t=e.element;t.find("[data-role='drawer-item']").first().parent().attr("role","menu").attr("aria-orientation","vertical"),this.options.navigatable&&t.attr("tabIndex",0).on("focus"+a,e._focus.bind(e)).on("focusout"+a,e._blur.bind(e)).on("keydown"+a,e,e._keyDown.bind(e))},_blur:function(){this._current&&this._current.removeClass(n)},_focus:function(){var e=this;e._setCurrent(e._current?e._current:e.drawerItemsWrapper.find("[data-role='drawer-item']").eq(0))},_setCurrent:function(t){var r=this,a=i.guid(),s=e(t);r._current&&(e(r._current).removeClass(n).removeAttr("id"),r.element.removeAttr("aria-activedescendant")),s.attr("id",a).addClass(n),r.element.attr("aria-activedescendant",a),r._current=s},_keyDown:function(t){var i,r=this,a=!1,n=r._current;t.keyCode==s.UP&&(a=!0,(i=n.prevAll("[data-role='drawer-item']").first()).length?r._setCurrent(i):r._setCurrent(n.parent().find("[data-role='drawer-item']").last())),t.keyCode==s.DOWN&&(a=!0,(i=n.nextAll("[data-role='drawer-item']").first()).length?r._setCurrent(i):r._setCurrent(n.parent().find("[data-role='drawer-item']").first())),t.keyCode==s.HOME&&(a=!0,r._setCurrent(r.drawerItemsWrapper.find("[data-role='drawer-item']").eq(0))),t.keyCode==s.END&&(a=!0,r._setCurrent(r.drawerItemsWrapper.find("[data-role='drawer-item']").last())),t.keyCode!=s.SPACEBAR&&t.keyCode!=s.ENTER||(a=!0,r.tap({event:{target:n[0]},preventDefault:e.noop})),t.keyCode==s.ESC&&(a=!0,r.hide()),a&&t.preventDefault()},_wrapper:function(){var t=this.options,i=this.drawerElement,r=this.element,a=this.contentElement,n=this.drawerItemsWrapper=i.wrapAll("<div class='k-drawer-items'></div>").parent(),s=this.drawerWrapper=n.wrap("<div class='k-drawer-wrapper'></div>").parent(),h=this.drawerContainer=r.wrap("<div class='k-drawer-container'></div>").parent();t.mini?t.mini.width&&s.width(t.mini.width):s.width(0),t.mode===d?h.append(a):t.mode===o&&(h.after(a),e(document.body).prepend(h)),r.append(s)},_setBodyOffset:function(){var t=this.element.outerWidth();this.leftPositioned?e(document.body).css("padding-left",t):e(document.body).css("padding-right",t)},_initDrawerItems:function(){var e=this.drawerItemsWrapper,t=e.find("[data-role='drawer-item']"),i=e.find("[data-role='drawer-separator']");t.addClass("k-drawer-item").attr("role","menuitem"),i.addClass("k-drawer-item k-drawer-separator").attr("role","separator"),t.each(((e,t)=>{t.setAttribute("aria-label",t.textContent.trim())})),this._selectedItemIndex>=0&&(t.removeClass("k-selected"),t.eq(this._selectedItemIndex).addClass("k-selected"))},_mode:function(){var t,i=this.options,r=this.drawerContainer;i.mode==d?r.addClass("k-drawer-push"):(r.addClass("k-drawer-overlay"),(t=this.overlayContainer=e('<div class="k-overlay"></div>')).hide(),r.prepend(t))},_miniMode:function(){var t=this.options,i=this.drawerContainer,r=t.mini.width,a=this._miniTemplate=t.mini.template&&e(t.mini.template),n=this.drawerItemsWrapper,s=this.drawerWrapper;i.addClass("k-drawer-mini"),a&&n.html(a),r&&s.width(r),this.minWidth=t.mini.width||this.drawerWrapper.width()},show:function(){var e=this.drawerWrapper,t=this.drawerContainer,i=this.options,r=t.hasClass("k-drawer-expanded"),a=this._miniTemplate,n=this.drawerElement,s=this.drawerItemsWrapper;r||(t.addClass("k-drawer-expanded"),this.visible=!0),a&&(s.html(n),this._initDrawerItems(),this._selectItem()),e.width(i.width),i.mini&&t.removeClass("k-drawer-mini"),i.mode===o&&(this.overlayContainer.show(),this.visible=!0)},hide:function(){var e=this,t=e.drawerWrapper,i=e.drawerContainer,r=this.options,a=this.drawerItemsWrapper,n=this._miniTemplate,s=r.mini&&r.mini.width;this._miniTemplate&&(a.html(n),e._initDrawerItems(),this._selectItem()),r.mini?(i.addClass("k-drawer-mini"),s?t.width(s):t.width("")):t.width(0),this.visible&&(i.removeClass("k-drawer-expanded"),this.visible=!1),r.mode===o&&this.overlayContainer.hide()},position:function(e){var t=this,i=t.options,r=e||i.position;"right"==r?(t.element.removeClass("k-drawer-start"),t.element.addClass("k-drawer-end")):(t.element.removeClass("k-drawer-end"),t.element.addClass("k-drawer-start")),this.leftPositioned=r===h},_start:function(e){var t=this.options,r=this.drawerWrapper,a=this.drawerItemsWrapper,n=e.sender;Math.abs(e.x.velocity)<Math.abs(e.y.velocity)||i.triggeredByInput(e.event)?n.cancel():(this.drawerMini&&a.html(this.drawerElement),r.css("transition","none"),t.mode!=d&&this.overlayContainer.show())},_update:function(e){this.options.mode==d?this._push(e):this._overlay(e)},_end:function(e){var t=e.x.velocity,i=this.options,r=this.drawerWrapper,a=r.width()>i.width/2,n=.8;r.css("transition","all .3s ease-out"),(this.leftPositioned?t>-.8&&(t>n||a):t<n&&(t<-.8||a))?this.trigger("show",{sender:this})?(e.preventDefault(),this.hide()):this.show():this.trigger("hide",{sender:this})?(e.preventDefault(),this.show()):this.hide()},_overlay:function(e){var t,i,r=this.options,a=r.mini&&r.mini.width||this.minWidth||0,n=this.drawerWrapper;i=n.width()+(this.leftPositioned?e.x.delta:-e.x.delta),t=Math.min(Math.max(i,a),r.width),e.event.preventDefault(),e.event.stopPropagation(),n.width(t)},_push:function(e){var t,i,r=this.options,a=r.mini&&r.mini.width||this.minWidth||0,n=this.drawerWrapper;i=n.width()+(this.leftPositioned?e.x.delta:-e.x.delta),t=Math.min(Math.max(i,a),r.width),e.event.preventDefault(),e.event.stopPropagation(),n.width(t)},_selectItem:function(e){var t;if(e)return e.addClass("k-selected"),this.trigger("itemClick",{item:e,sender:this}),void(this._selectedItemIndex=e.index());(t=this._selectedItemIndex)&&this.drawerItemsWrapper.find("[data-role='drawer-item']").eq(t).addClass("k-selected")},_itemClick:function(t){var i,r=this;e(t.event.target).find(".k-drawer-item").length>0?i=e(t.event.target).find(".k-drawer-item"):e(t.event.target).closest(".k-drawer-item").length>0?i=e(t.event.target).closest(".k-drawer-item"):e(t.event.target).hasClass(".k-drawer-item")&&(i=e(t.event.target)),r.drawerItemsWrapper.find(".k-drawer-item").removeClass("k-selected"),r._selectItem(i),r.options.navigatable&&r._setCurrent(i)},destroy:function(){this.options.mode!=d&&(this.leftPositioned?e(document.body).css("padding-left",0):e(document.body).css("padding-right",0)),r.fn.destroy.call(this),this.userEvents.destroy(),i.destroy(this.element),this.element=this.drawerWrapper=this.drawerElement=this.drawerContainer=this.drawerItemsWrapper=this._miniTemplate=null},options:{name:"Drawer",autoCollapse:!0,position:h,mode:"overlay",swipeToOpen:!0,width:280,mini:!1,navigatable:!1,template:""},events:["hide","show","itemClick"]});i.ui.plugin(l)}(window.kendo.jQuery);
//# sourceMappingURL=kendo.drawer.js.map
