/**
 * Kendo UI v2023.1.314 (http://www.telerik.com/kendo-ui)
 * Copyright 2023 Progress Software Corporation and/or one of its subsidiaries or affiliates. All rights reserved.
 *
 * Kendo UI commercial licenses may be obtained at
 * http://www.telerik.com/purchase/license-agreement/kendo-ui-complete
 * If you do not own a commercial license, this file shall be governed by the trial license terms.
 */
import"./kendo.data.js";import"./kendo.treeview.draganddrop.js";import"./kendo.html.input.js";import"./kendo.icons.js";var __meta__={id:"treeview",name:"TreeView",category:"web",description:"The TreeView widget displays hierarchical data in a traditional tree structure,with support for interactive drag-and-drop operations.",depends:["data","html.input","icons"],features:[{id:"treeview-dragging",name:"Drag & Drop",description:"Support for drag & drop",depends:["treeview.draganddrop"]}]};!function(e,t){var n,r,i,a,s,o=window.kendo,d=o.ui,l=o.data,c=o.htmlEncode,h=e.extend,u=o.template,p=Array.isArray,f=d.Widget,g=l.HierarchicalDataSource,m=o.keys,k=".kendoTreeView",v=".kendoTreeViewTemp",_="select",b="check",x="navigate",C="change",w="error",y="checked",S="indeterminate",N="dragstart",T="drag",I="drop",D="dragend",A="dataBound",B="itemsLoaded",E="loadCompleted",H="requestEnd",O="click",$="undefined",q="k-hover",L="k-treeview",V=".k-item",U="<span class='k-toggle-icon'></span>",F="string",j="aria-checked",R="aria-selected",P="aria-disabled",M="aria-expanded",G="aria-activedescendant",Q="aria-busy",W="k-disabled",J={text:"dataTextField",url:"dataUrlField",spriteCssClass:"dataSpriteCssClassField",imageUrl:"dataImageUrlField"},X=function(e){return"object"==typeof HTMLElement?e instanceof HTMLElement:e&&"object"==typeof e&&1===e.nodeType&&typeof e.nodeName===F};function Y(e){return function(t){var n=t.children(".k-animation-container");return n.length||(n=t),n.children(e)}}function z(e){return e.find(".k-checkbox-wrapper:first input[type=checkbox]")}function K(e){return function(t,n){var r,i=(n=n.closest(V)).parent();return i.parent().is("li")&&(r=i.parent()),this._dataSourceMove(t,i,r,(function(t,r){var i=this.dataItem(n),a=i&&n.parent().children().length!==i.parent().length?i.parent().indexOf(i):n.index();return this._insert(t.data(),r,a+e)}))}}function Z(t){var n=t.children("div"),r=t.children("ul"),i=n.find(".k-treeview-toggle > .k-toggle-icon"),a=t.children("input[type=checkbox]"),d=n.children(".k-in");t.hasClass("k-treeview")||(n.length||(n=e("<div />").prependTo(t)),!i.length&&r.length?i=e(`<span class='k-treeview-toggle'>${U}</span>`).prependTo(n):r.length&&r.children().length||(i.parent().remove(),r.remove(),t.removeAttr(M)),a.length&&e("<span class='k-checkbox-wrapper' />").appendTo(n).append(a),d.length||((d=t.children("a").eq(0).addClass("k-in k-link")).length||(d=e("<span class='k-treeview-leaf k-in' />")),d.appendTo(n),n.length&&function(e,t){for(var n;e&&"ul"!=e.nodeName.toLowerCase();)n=e,e=e.nextSibling,3==n.nodeType&&(n.nodeValue=o.trim(n.nodeValue)),s.test(n.className)?t.insertBefore(n,t.firstChild):t.appendChild(n)}(n[0].nextSibling,d[0])))}r=Y(".k-group"),i=Y(".k-group,.k-content"),a=function(e){return e.children("div").find(".k-treeview-toggle > .k-toggle-icon")},s=/k-sprite/,n=o.ui.DataBoundWidget.extend({init:function(e,t){var n,r,i=this,a=t&&!!t.dataSource;p(t)&&(t={dataSource:t}),t&&typeof t.loadOnDemand==$&&p(t.dataSource)&&(t.loadOnDemand=!1),f.prototype.init.call(i,e,t),e=i.element,t=i.options,i._dataSourceUids={},r=e.is("ul")&&e||e.hasClass(L)&&e.children("ul"),(n=!a&&r.length)&&(t.dataSource.list=r),i._animation(),i._accessors(),i._templates(),e.hasClass(L)?(i.wrapper=e,i.root=e.children("ul").eq(0)):(i._wrapper(),r&&(i.root=e,i._group(i.wrapper))),i._applyCssClasses(),i._tabindex(),i.wrapper.attr("role","tree"),i.wrapper.find(">ul").attr("role","none"),i._dataSource(n),i._attachEvents(),i._dragging(),n?i._syncHtmlAndDataSource():t.autoBind&&(i._progress(!0),i.dataSource.fetch(this._attemptLoadCompleted.bind(this))),t.checkboxes&&t.checkboxes.checkChildren&&i.updateIndeterminate(),i.element[0].id?i._ariaId=o.format("{0}_tv_active",i.element[0].id):i._ariaId=o.guid()+"_tv_active",o.notify(i)},_attachEvents:function(){var t=this,n=".k-in:not(.k-selected,.k-disabled)",r="mouseenter";t._clickHandler=t._click.bind(t),t.wrapper.on(r+k,".k-in.k-selected",(function(e){e.preventDefault()})).on(r+k,n,(function(){e(this).addClass(q)})).on("mouseleave"+k,n,(function(){e(this).removeClass(q)})).on(O+k,n,t._clickHandler).on("dblclick"+k,".k-in:not(.k-disabled)",t._toggleButtonClick.bind(t)).on(O+k,".k-toggle-icon",t._toggleButtonClick.bind(t)).on("keydown"+k,t,t._keydown.bind(t)).on("keypress"+k,t._keypress.bind(t)).on("focus"+k,t._focus.bind(t)).on("blur"+k,t._blur.bind(t)).on("mousedown"+k,".k-in,.k-checkbox-wrapper :checkbox,.k-toggle-icon",t._mousedown.bind(t)).on("change"+k,".k-checkbox-wrapper :checkbox",t._checkboxChange.bind(t)).on("click"+k,".k-request-retry",t._retryRequest.bind(t)).on("click"+k,".k-link.k-disabled",(function(e){e.preventDefault()})).on("click"+k,(function(n){var r=e(n.target);r.is(":kendoFocusable")||r.find("input,select,textarea,button,object").is(":kendoFocusable")||t.focus()}))},_syncHtmlAndDataSource:function(e,t){e=e||this.root;var n,r,i,a,s,d=(t=t||this.dataSource).view(),l=o.attr("uid"),c=o.attr("expanded"),h=this.options.checkboxes,u=e.children("li");for(n=0;n<u.length;n++)a=(i=d[n]).uid,(r=u.eq(n)).attr("role","treeitem").attr(l,a).attr(R,r.hasClass("k-selected")),i.expanded="true"===r.attr(c),i.hasChildren&&r.attr(M,i.expanded),h&&(s=z(r),i.checked=s.prop(y),s.attr("id","_"+a),s.next(".k-checkbox-label").attr("for","_"+a),r.attr(j,r.checked)),this._syncHtmlAndDataSource(r.children("ul"),i.children)},_animation:function(){var e=this.options,t=e.animation,n=t.collapse&&"effects"in t.collapse,r=h({},t.expand,t.collapse);n||(r=h(r,{reverse:!0})),!1===t&&(t={expand:{effects:{}},collapse:{hide:!0,effects:{}}}),t.collapse=h(r,{hide:!0}),e.animation=t},_dragging:function(){var t=this.options.dragAndDrop,n=this.dragging;if(t&&!n){var r=this;this.dragging=new d.HierarchicalDragAndDrop(this.element,{reorderable:!0,$angular:this.options.$angular,autoScroll:this.options.autoScroll,filter:"div:not(.k-disabled) .k-in",allowedContainers:".k-treeview",itemSelector:".k-treeview .k-item",hintText:this._hintText.bind(this),contains:function(t,n){return e.contains(t,n)},dropHintContainer:function(e){return e},itemFromTarget:function(e){var t=e.closest(".k-treeview-top,.k-treeview-mid,.k-treeview-bot");return{item:t,content:e.closest(".k-in"),first:t.hasClass("k-treeview-top"),last:t.hasClass("k-treeview-bot")}},dropPositionFrom:function(e){return e.prevAll(".k-in").length>0?"after":"before"},dragstart:function(e){return r.wrapper.attr(o.attr("scrollable"),!1),r.trigger(N,{sourceNode:e[0]})},drag:function(e){r.trigger(T,{originalEvent:e.originalEvent,sourceNode:e.source[0],dropTarget:e.target[0],pageY:e.pageY,pageX:e.pageX,statusClass:e.status,setStatusClass:e.setStatus})},drop:function(t){var n=e(t.dropTarget).closest("a");return n&&n.attr("href")&&r._tempPreventNavigation(n),r.trigger(I,{originalEvent:t.originalEvent,sourceNode:t.source,destinationNode:t.destination,valid:t.valid,setValid:function(e){this.valid=e,t.setValid(e)},dropTarget:t.dropTarget,dropPosition:t.position})},dragend:function(e){var t=e.source,n=e.destination,i=e.position;function a(t){r.options.checkboxes&&r.options.checkboxes.checkChildren&&r.updateIndeterminate(),r.current(t),r.element.focus(),r.trigger(D,{originalEvent:e.originalEvent,sourceNode:t&&t[0],destinationNode:n[0],dropPosition:i})}r.wrapper.removeAttr(o.attr("scrollable")),"over"==i?r.append(t,n,a):("before"==i?t=r.insertBefore(t,n):"after"==i&&(t=r.insertAfter(t,n)),a(t))}})}else!t&&n&&(n.destroy(),this.dragging=null)},_tempPreventNavigation:function(e){e.on(O+k+v,(function(t){t.preventDefault(),e.off(O+k+v)}))},_hintText:function(e){return this.templates.dragClue({item:this.dataItem(e),treeview:this.options})},_templates:function(){var t=this,n=t.options,r=t._fieldAccessor.bind(t);n.template&&typeof n.template==F?n.template=u(n.template):n.template||(n.template=({item:e})=>{var t=r("text")(e);return void 0!==e.encoded&&!1===e.encoded?`<span class='k-treeview-leaf-text'>${t}</span>`:`<span class='k-treeview-leaf-text'>${c(t)}</span>`}),t._checkboxes(),t.templates={setAttributes:function(e){var t="",n=e.attr||{};for(var r in n)n.hasOwnProperty(r)&&"class"!==r&&(t+=r+'="'+n[r]+'" ');return t},wrapperCssClass:function(e,t){var n="k-item k-treeview-item",r=t.index;return e.firstLevel&&0===r&&(n+=" k-first"),r==e.length-1&&(n+=" k-last"),n},cssClass:function(e,t){var n="",r=t.index,i=e.length-1;return e.firstLevel&&0===r&&(n+="k-treeview-top "),n+=0===r&&r!=i?"k-treeview-top":r==i?"k-treeview-bot":"k-treeview-mid"},textClass:function(e,t){var n="k-treeview-leaf k-in";return t&&(n+=" k-link"),!1===e.enabled&&(n+=" k-disabled"),!0===e.selected&&(n+=" k-selected"),n},checkboxClass:function(e){var t="k-checkbox";return!1===e.enabled&&(t+=" k-disabled"),t},toggleButtonClass:function(e){var t="k-treeview-toggle";return!1===e.enabled&&(t+=" k-disabled"),t},toggleIcon:function(e,t){return!0!==t.expanded?d.icon(e,{icon:"caret-alt-right"}):d.icon(e,{icon:"caret-alt-down"})},groupAttributes:function(e){var t="";return e.firstLevel||(t="role='group'"),t+(!0!==e.expanded?" style='display:none'":"")},groupCssClass:function(e){var t="k-group k-treeview-group";return e.firstLevel&&(t+=" k-treeview-lines"),t},dragClue:e=>e.treeview.template(e),group:e=>`<ul class='${e.r.groupCssClass(e.group)}'${e.r.groupAttributes(e.group)}>`+e.renderItems(e)+"</ul>",itemContent:e=>{var t=r("imageUrl")(e.item),n=r("spriteCssClass")(e.item),i="";return t&&(i+=`<img class='k-image' alt='' src='${t}'>`),n&&(i+=`<span class='k-sprite ${n}'></span>`),i+=e.treeview.template(e)},itemElement:t=>{var n=t.item,i=t.r,a=r("url")(n),s=a?"a":"span",o=a?' href="'+a+'"':"",d=`<div class="${i.cssClass(t.group,n)}">`;return n.hasChildren&&(d+=`<span class='${i.toggleButtonClass(n)}'>`+i.toggleIcon(e(U),n)+"</span>"),t.treeview.checkboxes&&(d+="<span class='k-checkbox-wrapper' role='presentation'>"+t.treeview.checkboxes.template(t)+"</span>"),d+=`<${s} class='${i.textClass(n,!!a)}'${o}>`+i.itemContent(t)+`</${s}>`,d+="</div>"},item:e=>{var t=e.item,n=e.r,r=`<li role='treeitem' class="${n.wrapperCssClass(e.group,t)}"${o.attr("uid")}="${t.uid}"${n.setAttributes(t.toJSON?t.toJSON():t)} `;return e.treeview.checkboxes&&(r+=`aria-checked="${t.checked?"true":"false"}" `),r+=`aria-selected="${t.selected?"true":"false"}" `+(!1===t.enabled?'aria-disabled="true"':""),t.hasChildren&&(r+=`aria-expanded="${t.expanded?"true":"false"}" `),r+=`data-expanded="${t.expanded?"true":"false"}" >`+n.itemElement(e)+"</li>"},loading:({messages:e})=>`<div class='k-icon k-i-loading'></div> ${c(e.loading)}`,retry:({messages:e})=>`${c(e.requestFailed)} <button class='k-button k-button-md k-rounded-md k-button-solid k-button-solid-base k-request-retry'><span class='k-button-text'>${c(e.retry)}</span></button>`}},items:function(){return this.element.find(".k-item > div:first-child")},setDataSource:function(e){var t=this.options;t.dataSource=e,this._dataSourceUids={},this._dataSource(),t.checkboxes&&t.checkboxes.checkChildren&&this.dataSource.one("change",this.updateIndeterminate.bind(this,null)),this.options.autoBind&&this.dataSource.fetch(this._attemptLoadCompleted.bind(this))},_bindDataSource:function(){var e=this;e._refreshHandler=e.refresh.bind(e),e._errorHandler=e._error.bind(e),e._loadCompletedHandler=e._loadCompleted.bind(e),e._requestEndHandler=e._dsRequestEnd.bind(e),e._loadedNodes=[],e.dataSource.bind(C,e._refreshHandler),e.dataSource.bind(w,e._errorHandler),e.dataSource.bind(B,e._loadCompletedHandler),e.dataSource.bind(H,e._requestEndHandler)},_dsRequestEnd:function(e){var t=this;setTimeout((function(){"read"!==e.type||t._loadCompletedFired||t._attemptLoadCompleted()}))},_loadCompleted:function(e){var t=this;t._loadedNodes=t._loadedNodes.concat(e.nodes),t.dataSource.loading()||!1!==t.options.loadOnDemand||(t.trigger(E,{nodes:t._loadedNodes}),t._loadedNodes=[])},_attemptLoadCompleted:function(){var e,t,n=this,r=n.dataSource.view();if(!1===n.options.loadOnDemand){for(t=0;t<r.length;t++)if((e=r[t]).hasChildren&&(!e.children||!e.children.data()||0===e.children.data().length))return;n._loadCompletedFired=!0,n.trigger(E,{nodes:[]})}},_unbindDataSource:function(){var e=this.dataSource;e&&(e.unbind(C,this._refreshHandler),e.unbind(w,this._errorHandler),e.unbind(B,this._loadCompletedHandler),e.unbind(H,this._requestEndHandler))},_dataSource:function(e){var t=this,n=t.options.dataSource;n=p(n)?{data:n}:n,t._unbindDataSource(),n.fields||(n.fields=[{field:"text"},{field:"url"},{field:"spriteCssClass"},{field:"imageUrl"}]),t.dataSource=n=g.create(n),e&&(n.fetch(),function e(t){for(var n=0;n<t.length;n++)t[n]._initChildren(),t[n].children.fetch(),e(t[n].children.view())}(n.view())),t._bindDataSource()},events:[N,T,I,D,A,E,"expand","collapse",_,C,x,b,"kendoKeydown"],options:{name:"TreeView",dataSource:{},animation:{expand:{effects:"expand:vertical",duration:200},collapse:{duration:100}},messages:{loading:"Loading...",requestFailed:"Request failed.",retry:"Retry"},dragAndDrop:!1,checkboxes:!1,autoBind:!0,autoScroll:!1,loadOnDemand:!0,template:"",dataTextField:null,size:"medium"},_accessors:function(){var e,t,n,r=this.options,i=this.element;for(e in J)t=r[J[e]],n=i.attr(o.attr(e+"-field")),!t&&n&&(t=n),t||(t=e),p(t)||(t=[t]),r[J[e]]=t},_fieldAccessor:function(t){var n=this.options[J[t]],r=n.length;return function(i){return 0===r?o.getter(t)(i):e.map(n,(function(e){return function(t){return o.getter(e)(t)}}))[Math.min(i.level(),r-1)](i)}},setOptions:function(e){f.fn.setOptions.call(this,e),this._animation(),this._dragging(),this._accessors(),this._templates()},_trigger:function(e,t){return this.trigger(e,{node:t.closest(V)[0]})},_setChecked:function(e,t){if(e&&o.isFunction(e.view))for(var n=0,r=e.view();n<r.length;n++)!1!==r[n].enabled&&this._setCheckedValue(r[n],t),r[n].children&&this._setChecked(r[n].children,t)},_setCheckedValue:function(e,t){e.checked=t},_setIndeterminate:function(e){var t,n,i,a=r(e),s=!0;if(a.length&&(n=(t=z(a.children())).length)){if(n>1){for(i=1;i<n;i++)if(t[i].checked!=t[i-1].checked||t[i].indeterminate||t[i-1].indeterminate){s=!1;break}}else s=!t[0].indeterminate;return e.attr(j,s?t[0].checked:"mixed"),z(e).data(S,!s).prop(S,!s).prop(y,s&&t[0].checked)}},updateIndeterminate:function(e){e=e||this.wrapper;var t,n,i,a=r(e).children();if(a.length){for(t=0;t<a.length;t++)this.updateIndeterminate(a.eq(t));if(e.is(".k-treeview"))return;n=this._setIndeterminate(e),i=this.dataItem(e),n&&n.prop(y)?i.checked=!0:i&&delete i.checked}},_bubbleIndeterminate:function(e,t){if(e.length){t||this.updateIndeterminate(e);var n,r=this.parent(e);r.length&&(this._setIndeterminate(r),n=r.children("div").find(".k-checkbox-wrapper input[type=checkbox]"),this._skip=!0,!1===n.prop(S)?this.dataItem(r).set(y,n.prop(y)):this.dataItem(r).set(y,!1),this._skip=!1,this._bubbleIndeterminate(r,!0))}},_checkboxChange:function(t){var n=e(t.target),r=n.prop(y),i=n.closest(V),a=this.dataItem(i);this._preventChange||(a.checked!=r&&(a.set(y,r),i.attr(j,r),this._trigger(b,i)),n.is(":focus")&&(this._trigger(x,i),this.focus()))},_toggleButtonClick:function(t){var n=e(t.currentTarget).closest(V);n.is("[aria-disabled='true']")||this.toggle(n)},_mousedown:function(t){var n=this,r=e(t.currentTarget),i=e(t.currentTarget).closest(V),a=o.support.browser;i.is("[aria-disabled='true']")||((a.msie||a.edge)&&r.is(":checkbox")&&(r.prop(S)?(n._preventChange=!1,r.prop(y,!r.prop(y)),r.trigger(C),r.on(O+k,(function(e){e.preventDefault()})),n._preventChange=!0):(r.off(O+k),n._preventChange=!1)),n._clickTarget=i,n.current(i))},_focusable:function(e){return e&&e.length&&e.is(":visible")&&!e.find(".k-in").first().hasClass(W)},_focus:function(){var t=this.select(),n=this._clickTarget;o.support.touch||(n&&n.length&&(t=n),this._focusable(t)||(t=this.current()),this._focusable(t)||(t=this._nextVisible(e())),this.current(t))},focus:function(){var e,t=this.wrapper,n=t[0],r=[],i=[],a=document.documentElement;do{(n=n.parentNode).scrollHeight>n.clientHeight&&(r.push(n),i.push(n.scrollTop))}while(n!=a);for(o.focusElement(t),e=0;e<r.length;e++)r[e].scrollTop=i[e]},_blur:function(){this.current().find(".k-in").first().removeClass("k-focus")},_enabled:function(e){return!e.children("div").children(".k-in").hasClass(W)},parent:function(t){var n,r,i=/\bk-treeview\b(?!-)/,a=/\bk-item\b/;typeof t==F&&(t=this.element.find(t)),X(t)||(t=t[0]),r=a.test(t.className);do{t=t.parentNode,a.test(t.className)&&(r?n=t:r=!0)}while(!i.test(t.className)&&!n);return e(n)},_nextVisible:function(e){var t,n=this,i=n._expanded(e);function a(e){for(;e.length&&!e.next().length;)e=n.parent(e);return e.next().length?e.next():e}return e.length&&e.is(":visible")?i&&(t=r(e).children().first()).length||(t=a(e)):t=n.root.children().eq(0),t},_previousVisible:function(e){var t,n,i=this;if(!e.length||e.prev().length)for(n=e.length?e.prev():i.root.children().last();i._expanded(n)&&(t=r(n).children().last()).length;)n=t;else n=i.parent(e)||e;return n},_keydown:function(n){var r,i=this,a=n.keyCode,s=i.current(),d=i._expanded(s),l=s.find(".k-checkbox-wrapper").first().find(":checkbox"),c=o.support.isRtl(i.element);n.target==n.currentTarget&&(!c&&a==m.RIGHT||c&&a==m.LEFT?d?r=i._nextVisible(s):s.find(".k-in").first().hasClass(W)||i.expand(s):!c&&a==m.LEFT||c&&a==m.RIGHT?d&&!s.find(".k-in").first().hasClass(W)?i.collapse(s):(r=i.parent(s),i._enabled(r)||(r=t)):a==m.DOWN?r=i._nextVisible(s):a==m.UP?r=i._previousVisible(s):a==m.HOME?r=i._nextVisible(e()):a==m.END?r=i._previousVisible(e()):a!=m.ENTER||s.find(".k-in").first().hasClass(W)?a==m.SPACEBAR&&l.length&&(s.find(".k-in").first().hasClass(W)||(l.prop(y,!l.prop(y)).data(S,!1).prop(S,!1),i._checkboxChange({target:l})),r=s):s.find(".k-in").first().hasClass("k-selected")||i._trigger(_,s)||i.select(s),r&&(n.preventDefault(),s[0]!=r[0]&&(i._trigger(x,r),i.current(r))))},_keypress:function(e){var t,n=this,r=n.current().get(0),i=e.key;1===i.length&&(n._match||(n._match=""),n._match+=i,clearTimeout(n._matchTimer),n._matchTimer=setTimeout((function(){n._match=""}),300),(t=r&&n._matchNextByText(Array.prototype.indexOf.call(n.element.find(".k-item"),r),n._match)).length||(t=n._matchNextByText(-1,n._match)),t.get(0)&&t.get(0)!==r&&(n._trigger(x,t),n.current(t)))},_matchNextByText:function(t,n){return this.element.find(".k-in").filter((function(r,i){return r>t&&e(i).is(":visible")&&0===e(i).text().toLowerCase().indexOf(n)})).eq(0).closest(V)},_click:function(t){var n=e(t.currentTarget),r=i(n.closest(V)),a=n.attr("href");(a?"#"==a||a.indexOf("#"+this.element.id+"-")>=0:r.length&&!r.children().length)&&t.preventDefault(),n.hasClass(".k-selected")||this._trigger(_,n)||this.select(n)},_wrapper:function(){var e,t,n=this,r=n.element;r.is("ul")?(e=r.wrap("<div />").parent(),t=r):t=(e=r).children("ul").eq(0),n.wrapper=e.addClass("k-treeview"),n.root=t},_getSelectedNode:function(){return this.element.find(".k-selected").closest(V)},_group:function(e){var t=this,n=e.hasClass(L),r={firstLevel:n,expanded:n||t._expanded(e)},i=e.children("ul");i.addClass(t.templates.groupCssClass(r)).css("display",r.expanded?"":"none"),n||i.attr("role","group"),t._nodes(i,r)},_nodes:function(t,n){var r,i=this,a=t.children("li");n=h({length:a.length},n),a.each((function(t,a){a=e(a),r={index:t,expanded:i._expanded(a)},Z(a),i._updateNodeClasses(a,n,r),i._group(a)}))},_checkboxes:function(){var t,n=this.options,r=n.checkboxes;r&&(t=(t=o.html.renderCheckBox(e("<input/>"),e.extend({},n,{rounded:"medium"}))).replace(">",""),typeof(r=h({template:({item:e})=>t+` id="_${e.uid}" aria-hidden="true" type="checkbox" tabindex="-1"`+(r.name?'name="'+r.name+'"':"")+" "+(!1===e.enabled?"disabled":"")+" "+(e.checked?"checked":"")+"/>"},n.checkboxes)).template==F&&(r.template=u(r.template)),n.checkboxes=r)},_updateNodeClasses:function(e,t,n){var r=e.children("div"),i=e.children("ul"),a=this.templates;if(!e.hasClass("k-treeview")){(n=n||{}).expanded=typeof n.expanded!=$?n.expanded:this._expanded(e),n.index=typeof n.index!=$?n.index:e.index(),n.enabled=typeof n.enabled!=$?n.enabled:!r.children(".k-in").hasClass("k-disabled"),(t=t||{}).firstLevel=typeof t.firstLevel!=$?t.firstLevel:e.parent().parent().hasClass(L),t.length=typeof t.length!=$?t.length:e.parent().children().length,e.removeClass("k-first k-last").addClass(a.wrapperCssClass(t,n)),r.removeClass("k-treeview-top k-treeview-mid k-treeview-bot").addClass(a.cssClass(t,n)),r.find(".k-checkbox").removeClass("k-checkbox k-disabled").addClass(a.checkboxClass(n));var s=r.children(".k-in"),o=s[0]&&"a"==s[0].nodeName.toLowerCase();if(s.removeClass("k-in k-link k-disabled").addClass(a.textClass(n,o)),i.length||"true"==e.attr("data-hasChildren")){var d=r.find(".k-treeview-toggle"),l=d.children(".k-toggle-icon");d.removeClass("k-treeview-toggle k-disabled").addClass(a.toggleButtonClass(n)),a.toggleIcon(l,n),i.addClass("k-group k-treeview-group")}}},_processNodes:function(t,n){for(var r=this.element.find(t),i=0;i<r.length;i++)n.call(this,i,e(r[i]).closest(V))},dataItem:function(t){var n=e(t).closest(V).attr(o.attr("uid")),r=this.dataSource;return r&&r.getByUid(n)},_dataItem:function(t){var n=e(t).closest(V).attr(o.attr("uid"));return this.dataSource&&this._dataSourceUids[n]},_insertNode:function(t,n,i,a,s){var d,l,c,h,u,p,f=this,g=r(i),m=g.children().length+1,k={firstLevel:i.hasClass(L),expanded:!s,length:m},v="",_=function(e,t){e.appendTo(t)};for(c=0;c<t.length;c++)(h=t[c]).index=n+c,v+=f._renderItem({group:k,item:h});if((l=e(v)).length){for(f.angular("compile",(function(){return{elements:l.get(),data:t.map((function(e){return{dataItem:e}}))}})),g.length||(g=e(f._renderGroup({group:k})).appendTo(i),i.attr(M,!0)),a(l,g),i.hasClass("k-item")&&(Z(i),f._updateNodeClasses(i,k,{expanded:!s})),u=l.prev().first(),p=l.next().last(),f._updateNodeClasses(u,{},{expanded:"true"==u.attr(o.attr("expanded"))}),f._updateNodeClasses(p,{},{expanded:"true"==p.attr(o.attr("expanded"))}),c=0;c<t.length;c++)(h=t[c]).hasChildren&&(d=h.children.data()).length&&f._insertNode(d,h.index,l.eq(c),_,!h.expanded);return l}},_updateNodes:function(t,n){var r,a,s,l,c,h,u=this,p={treeview:u.options,item:l},f="expanded"!=n&&"checked"!=n;function g(e,t){e.is(".k-group")&&e.find(".k-item:not([aria-disabled])").attr(j,t),e.find(".k-checkbox-wrapper input[type=checkbox]:not([disabled])").prop(y,t).data(S,!1).prop(S,!1)}if("selected"==n)l=t[0],(a=u.findByUid(l.uid)).find(".k-in").first().removeClass("k-hover").toggleClass("k-selected",l[n]).end(),l[n]&&u.current(a),a.attr(R,!!l[n]);else{var m=e.map(t,(function(e){return u.findByUid(e.uid).children("div")}));for(f&&u.angular("cleanup",(function(){return{elements:m}})),r=0;r<t.length;r++)p.item=l=t[r],a=(s=m[r]).parent(),f&&(o.unbind&&o.unbind(s),s.children(".k-in").html(u.templates.itemContent(p))),n==y?(g(s,c=l[n]),a.attr(j,c),u.options.checkboxes.checkChildren&&(g(a.children(".k-group"),c),u._setChecked(l.children,c),u._bubbleIndeterminate(a))):"expanded"==n?u._toggle(a,l,l[n]):"enabled"==n&&(a.find(".k-checkbox-wrapper input[type=checkbox]").prop("disabled",!l[n]),h=!i(a).is(":visible"),a.removeAttr(P),l[n]||(l.selected&&l.set("selected",!1),l.expanded&&l.set("expanded",!1),h=!0,a.attr(R,!1).attr(P,!0)),u._updateNodeClasses(a,{},{enabled:l[n],expanded:!h})),s.length&&this.trigger("itemChange",{item:s,data:l,ns:d});f&&u.angular("compile",(function(){return{elements:m,data:e.map(t,(function(e){return[{dataItem:e}]}))}}))}},_appendItems:function(e,t,n){var i=r(n).children(),a=!this._expanded(n);if(this.element===n){var s=this.dataSource.data(),o=this.dataSource.view(),d=o.length<s.length?o:s;e=d.indexOf(t[0])}else t.length&&(e=t[0].parent().indexOf(t[0]));typeof e==$&&(e=i.length),this._insertNode(t,e,n,(function(t,n){e>=i.length?t.appendTo(n):t.insertBefore(i.eq(e))}),a),a||(this._updateNodeClasses(n,{},{expanded:!a}),r(n).css("display","block"))},_refreshChildren:function(e,t,n){var i,a,s,o=this.options,l=o.loadOnDemand,c=o.checkboxes&&o.checkboxes.checkChildren;if(r(e).empty(),t.length)for(this._appendItems(n,t,e),a=r(e).children(),l&&c&&this._bubbleIndeterminate(a.last()),i=0;i<a.length;i++)s=a.eq(i),this.trigger("itemChange",{item:s.children("div"),data:t[i],ns:d});else Z(e)},_refreshRoot:function(t){var n=this._renderGroup({items:t,group:{firstLevel:!0,expanded:!0}});if(this.root.length&&this.root[0].parentElement){this._angularItems("cleanup");var r=e(n);this.root.attr("class",r.attr("class")).html(r.html())}else this.root=this.wrapper.html(n).children("ul");for(var i=this.root.children(".k-item"),a=0;a<t.length;a++)this.trigger("itemChange",{item:i.eq(a),data:t[a],ns:d});this._angularItems("compile")},refresh:function(e){var n,r=e.node,i=e.action,a=e.items,s=this.wrapper,o=this.options,d=o.loadOnDemand,l=o.checkboxes&&o.checkboxes.checkChildren;if(!this._skip){for(n=0;n<a.length;n++)this._dataSourceUids[a[n].uid]=a[n];if(e.field){if(!a[0]||!a[0].level)return;return this._updateNodes(a,e.field)}if(r&&(s=this.findByUid(r.uid),this._progress(s,!1)),l&&"remove"!=i){var c=!1;for(n=0;n<a.length;n++)if("checked"in a[n]){c=!0;break}if(!c&&r&&r.checked)for(n=0;n<a.length;n++)a[n].checked=!0}if("add"==i?this._appendItems(e.index,a,s):"remove"==i?this._remove(this.findByUid(a[0].uid),!1):"itemchange"==i?this._updateNodes(a):"itemloaded"==i?this._refreshChildren(s,a,e.index):(this._refreshRoot(a),this.element.attr(Q,!1)),"remove"!=i)for(n=0;n<a.length;n++)(!d||a[n].expanded||a[n]._loaded)&&a[n].load();this.wrapper.find(">ul").attr("role","none"),this.trigger(A,{node:r?s:t}),this.dataSource.filter()&&this.options.checkboxes.checkChildren&&this.updateIndeterminate(s)}},_error:function(t){var n=t.node&&this.findByUid(t.node.uid),r=this.templates.retry({messages:this.options.messages});n?(this._progress(n,!1),this._expanded(n,!1),a(n).replaceWith(d.icon(e(U),{icon:"arrow-rotate-cw"})),t.node.loaded(!1)):(this._progress(!1),this.dataSource.data([]),this.element.html(r))},_retryRequest:function(e){e.preventDefault(),this.dataSource.fetch(this._attemptLoadCompleted.bind(this))},expand:function(e){this._processNodes(e,(function(e,t){this.toggle(t,!0)}))},collapse:function(e){this._processNodes(e,(function(e,t){this.toggle(t,!1)}))},enable:function(e,t){"boolean"==typeof e?(t=e,e=this.items()):t=2!=arguments.length||!!t,this._processNodes(e,(function(e,n){this.dataItem(n).set("enabled",t)}))},current:function(t){var n=this,r=n._current,i=n.element;return arguments.length>0&&t&&t.length?(r&&r.find(".k-in").first().removeClass("k-focus"),(r=n._current=e(t,i).closest(V)).find(".k-in").first().addClass("k-focus"),void n._updateActiveDescendant()):(r||(r=n._nextVisible(e())),r)},_updateActiveDescendant:function(){var e=this._current,t=e[0].id||this._ariaId,n=this.element.find("#"+this._ariaId);n.length>0&&n.removeAttr("id"),this.wrapper.removeAttr(G),e.attr("id",t),this.wrapper.attr(G,t)},select:function(t){var n=this,r=n.element;if(!arguments.length)return r.find(".k-selected").closest(V);t=e(t,r).closest(V),r.find(".k-selected").each((function(){var t=n.dataItem(this);t?(t.set("selected",!1),delete t.selected):e(this).removeClass("k-selected")})),t.length&&(n.dataItem(t).set("selected",!0),n._clickTarget=t),n.trigger(C)},_toggle:function(e,t,n){var r,a=this.options,s=i(e),o=n?"expand":"collapse";s.data("animating")||(r=t&&t.loaded(),n&&!r?(a.loadOnDemand&&this._progress(e,!0),s.remove(),t.load()):(this._updateNodeClasses(e,{},{expanded:n}),n||s.css("height",s.height()).css("height"),s.kendoStop(!0,!0).kendoAnimate(h({reset:!0},a.animation[o],{complete:function(){n&&s.css("height","")}}))))},toggle:function(t,n){t=e(t),a(t)&&(1==arguments.length&&(n=!this._expanded(t)),this._expanded(t,n))},destroy:function(){var e=this;f.fn.destroy.call(e),e.wrapper.off(k),e.wrapper.find(".k-checkbox-wrapper :checkbox").off(k),e._clickHandler=null,e._unbindDataSource(),e.dragging&&e.dragging.destroy(),e._dataSourceUids={},o.destroy(e.element),e.root=e.wrapper=e.element=null},_expanded:function(e,t,n){var r,a=o.attr("expanded"),s=t,d=s?"expand":"collapse";if(1==arguments.length)return r=this._dataItem(e),"true"===e.attr(a)||r&&r.expanded;r=this.dataItem(e),i(e).data("animating")||!n&&this._trigger(d,e)||(s?(e.attr(a,"true"),e.attr(M,"true")):(e.removeAttr(a),e.attr(M,"false")),r&&(r.set("expanded",s),s=r.expanded))},_progress:function(t,n){var r=this.element,i=this.templates.loading({messages:this.options.messages});1==arguments.length?((n=t)?r.html(i):r.empty(),r.attr(Q,n)):(a(t).replaceWith(e(U).toggleClass("k-i-loading",n).toggleClass("k-icon",n)),t.attr(Q,n))},text:function(e,t){var n=this.dataItem(e),r=this.options[J.text],i=n.level(),a=r.length,s=r[Math.min(i,a-1)];if(!t)return n[s];n.set(s,t)},_objectOrSelf:function(t){return e(t).closest("[data-role=treeview]").data("kendoTreeView")||this},_dataSourceMove:function(t,n,r,i){var a,s=this._objectOrSelf(r||n),o=s.dataSource,d=e.Deferred().resolve().promise();return r&&r[0]!=s.element[0]&&((a=s.dataItem(r)).loaded()||(s._progress(r,!0),d=a.load()),r!=this.root&&((o=a.children)&&o instanceof g||(a._initChildren(),a.loaded(!0),o=a.children))),t=this._toObservableData(t),i.call(s,o,t,d)},_toObservableData:function(t){var n,r,i,a=t;return((i=t)instanceof o.jQuery||window.jQuery&&i instanceof window.jQuery||X(t))&&(n=this._objectOrSelf(t).dataSource,r=e(t).attr(o.attr("uid")),(a=n.getByUid(r))&&(a=n.remove(a))),a},_insert:function(e,t,n){t instanceof o.data.ObservableArray?t=t.toJSON():p(t)||(t=[t]);var r=e.parent();return r&&r._initChildren&&(r.hasChildren=!0,r._initChildren()),e.splice.apply(e,[n,0].concat(t)),this.findByUid(e[n].uid)},insertAfter:K(1),insertBefore:K(0),append:function(t,n,i){var a=this.root;if(!(n&&t instanceof jQuery&&n[0]===t[0]))return(n=n&&n.length?n:null)&&(a=r(n)),this._dataSourceMove(t,a,n,(function(t,r,a){var s,o=this;return a.done((function(){s=function(){n&&o._expanded(n,!0,!0);var e=t.data(),i=Math.max(e.length,0);return o._insert(e,r,i)}(),(i=i||e.noop)(s)})),s||null}))},_remove:function(t,n){var r,i,a,s=this;return(t=e(t,s.element)).attr("id")===s.element.attr(G)&&s.element.removeAttr(G),this.angular("cleanup",(function(){return{elements:t.get()}})),r=t.parent().parent(),i=t.prev(),a=t.next(),t[n?"detach":"remove"](),r.hasClass("k-item")&&(Z(r),s._updateNodeClasses(r)),s._updateNodeClasses(i),s._updateNodeClasses(a),t},remove:function(e){var t=this.dataItem(e);t&&this.dataSource.remove(t)},detach:function(e){return this._remove(e,!0)},findByText:function(t){return e(this.element).find(".k-in").filter((function(n,r){return e(r).text()==t})).closest(V)},findByUid:function(t){for(var n,r=this.element.find(".k-item"),i=o.attr("uid"),a=0;a<r.length;a++)if(r[a].getAttribute(i)==t){n=r[a];break}return e(n)},expandPath:function(t,n){var r=this,i=t.slice(0),a=n||e.noop;function s(t){var n,i=e.Deferred(),a=r.dataSource.get(t),s=o.attr("expanded");return a?(n=r.findByUid(a.uid),a.loaded()?(a.set("expanded",!0),n.attr(s,!0),n.attr(M,!0),i.resolve()):(r._progress(n,!0),a.load().then((function(){a.set("expanded",!0),n.attr(s,!0),n.attr(M,!0),i.resolve()})))):i.resolve(),i.promise()}s(i[0]).then((function e(){i.shift(),i.length?s(i[0]).then(e):a.call(r)}))},_parentIds:function(e){for(var t=e&&e.parentNode(),n=[];t&&t.parentNode;)n.unshift(t.id),t=t.parentNode();return n},expandTo:function(e){e instanceof o.data.Node||(e=this.dataSource.get(e));var t=this._parentIds(e);this.expandPath(t)},_renderItem:function(e){return e.group||(e.group={}),e.treeview=this.options,e.r=this.templates,this.templates.item(e)},_renderGroup:function(e){var t=this;return e.renderItems=function(e){var n="",r=0,i=e.items,a=i?i.length:0,s=e.group;for(s.length=a;r<a;r++)e.group=s,e.item=i[r],e.item.index=r,n+=t._renderItem(e);return n},e.r=t.templates,t.templates.group(e)}}),o.cssProperties.registerPrefix("TreeView","k-treeview-"),d.plugin(n)}(window.kendo.jQuery);
//# sourceMappingURL=kendo.treeview.js.map
