/**
 * Kendo UI v2023.1.314 (http://www.telerik.com/kendo-ui)
 * Copyright 2023 Progress Software Corporation and/or one of its subsidiaries or affiliates. All rights reserved.
 *
 * Kendo UI commercial licenses may be obtained at
 * http://www.telerik.com/purchase/license-agreement/kendo-ui-complete
 * If you do not own a commercial license, this file shall be governed by the trial license terms.
 */
import"../kendo.core.js";!function(e,t){kendo.ui.FilterCell&&(kendo.ui.FilterCell.prototype.options.operators=e.extend(!0,kendo.ui.FilterCell.prototype.options.operators,{date:{eq:"рівними",gte:"після або рівна",gt:"після",lte:"до або рівними",lt:"до",neq:"не рівна"},number:{eq:"рівне",gte:"більше або рівними",gt:"більше",lte:"менше або рівними",lt:"менше",neq:"не рівними"},string:{endswith:"закінчуються на",eq:"рівні",neq:"не рівні",startswith:"починаються на",contains:"містять",doesnotcontain:"Does not contain"},enums:{eq:"рівними",neq:"не рівними"}})),kendo.ui.FilterMenu&&(kendo.ui.FilterMenu.prototype.options.operators=e.extend(!0,kendo.ui.FilterMenu.prototype.options.operators,{date:{eq:"рівними",gte:"після або рівна",gt:"після",lte:"до або рівними",lt:"до",neq:"не рівна"},number:{eq:"рівне",gte:"більше або рівними",gt:"більше",lte:"менше або рівними",lt:"менше",neq:"не рівними"},string:{endswith:"закінчуються на",eq:"рівні",neq:"не рівні",startswith:"починаються на",contains:"містять",doesnotcontain:"Does not contain"},enums:{eq:"рівними",neq:"не рівними"}})),kendo.ui.ColumnMenu&&(kendo.ui.ColumnMenu.prototype.options.messages=e.extend(!0,kendo.ui.ColumnMenu.prototype.options.messages,{columns:"Kолони",sortAscending:"Сортування за зростанням",sortDescending:"Сортування за спаданням",settings:"Параметри стовпців",done:"Зроблений",lock:"Замикати",unlock:"Відімкнути"})),kendo.ui.RecurrenceEditor&&(kendo.ui.RecurrenceEditor.prototype.options.messages=e.extend(!0,kendo.ui.RecurrenceEditor.prototype.options.messages,{daily:{interval:"days(s)",repeatEvery:"Repeat every:"},end:{after:"After",occurrence:"occurrence(s)",label:"End:",never:"Never",on:"On",mobileLabel:"Ends"},frequencies:{daily:"Daily",monthly:"Monthly",never:"Never",weekly:"Weekly",yearly:"Yearly"},monthly:{day:"Day",interval:"month(s)",repeatEvery:"Repeat every:",repeatOn:"Repeat on:"},offsetPositions:{first:"first",fourth:"fourth",last:"last",second:"second",third:"third"},weekly:{repeatEvery:"Repeat every:",repeatOn:"Repeat on:",interval:"week(s)"},yearly:{of:"of",repeatEvery:"Repeat every:",repeatOn:"Repeat on:",interval:"year(s)"},weekdays:{day:"day",weekday:"weekday",weekend:"weekend day"}})),kendo.ui.Grid&&(kendo.ui.Grid.prototype.options.messages=e.extend(!0,kendo.ui.Grid.prototype.options.messages,{commands:{create:"Додати",destroy:"Видалити",canceledit:"Скасувати",update:"Оновити",edit:"Редагувати",excel:"Export to Excel",pdf:"Export to PDF",select:"Вибрати",cancel:"Cancel Changes",save:"Save Changes"},editable:{confirmation:"Ви впевнені, що бажаєте видалити даний запис?",cancelDelete:"Скасувати",confirmDelete:"Видалити"}})),kendo.ui.Pager&&(kendo.ui.Pager.prototype.options.messages=e.extend(!0,kendo.ui.Pager.prototype.options.messages,{allPages:"All",page:"Сторінка",display:"Зображено записи {0} - {1} з {2}",of:"з {0}",empty:"немає записів",refresh:"Оновити",first:"Повернутися на першу сторінку",itemsPerPage:"елементів на сторінці",last:"До останньої сторінки",next:"Перейдіть на наступну сторінку",previous:"Перейти на попередню сторінку",morePages:"Більше сторінок"})),kendo.ui.TreeList&&(kendo.ui.TreeList.prototype.options.messages=e.extend(!0,kendo.ui.TreeList.prototype.options.messages,{noRows:"No records to display",loading:"Loading...",requestFailed:"Request failed.",retry:"Retry",commands:{edit:"Редагувати",update:"Оновити",canceledit:"Cancel",create:"Додати",createchild:"Add child record",destroy:"Видалити",excel:"Export to Excel",pdf:"Export to PDF"}})),kendo.ui.TreeListPager&&(kendo.ui.TreeListPager.prototype.options.messages=e.extend(!0,kendo.ui.TreeListPager.prototype.options.messages,{allPages:"All",page:"Сторінка",display:"Зображено записи {0} - {1} з {2}",of:"з {0}",empty:"немає записів",refresh:"Оновити",first:"Повернутися на першу сторінку",itemsPerPage:"елементів на сторінці",last:"До останньої сторінки",next:"Перейдіть на наступну сторінку",previous:"Перейти на попередню сторінку",morePages:"Більше сторінок"})),kendo.ui.FilterCell&&(kendo.ui.FilterCell.prototype.options.messages=e.extend(!0,kendo.ui.FilterCell.prototype.options.messages,{filter:"фільтрувати",clear:"очистити",isFalse:"хиба",isTrue:"істина",operator:"Oператор"})),kendo.ui.FilterMenu&&(kendo.ui.FilterMenu.prototype.options.messages=e.extend(!0,kendo.ui.FilterMenu.prototype.options.messages,{filter:"фільтрувати",and:"І",clear:"очистити",info:"Рядки із записами",title:"Рядки із записами",selectValue:"-виберіть-",isFalse:"хиба",isTrue:"істина",or:"Or",cancel:"Скасувати",operator:"Oператор",value:"Значення"})),kendo.ui.Groupable&&(kendo.ui.Groupable.prototype.options.messages=e.extend(!0,kendo.ui.Groupable.prototype.options.messages,{empty:"Перетягніть сюди заголовок стовпця, щоб згрупувати записи з цього стовпця"})),kendo.ui.Editor&&(kendo.ui.Editor.prototype.options.messages=e.extend(!0,kendo.ui.Editor.prototype.options.messages,{bold:"Жирний",createLink:"Додати посилання",fontName:"Шрифт",fontNameInherit:"(inherited font)",fontSize:"Розмір шрифта",fontSizeInherit:"(inherited size)",formatBlock:"Форматування",indent:"Збільшити відступ",insertHtml:"Додати HTML",insertImage:"Додати зображення",insertOrderedList:"Нумерований список",insertUnorderedList:"Маркований список",italic:"Курсив",justifyCenter:"По центру",justifyFull:"По ширині",justifyLeft:"По лівому краю",justifyRight:"По правому краю",outdent:"Зменшити відступ",strikethrough:"Закреслений",style:"Стиль",subscript:"Subscript",superscript:"Superscript",underline:"Підкреслений",unlink:"Видалити посилання",dialogButtonSeparator:"or",dialogCancel:"Cancel",dialogInsert:"Insert",imageAltText:"Alternate text",imageWebAddress:"Web address",linkOpenInNewWindow:"Open link in new window",linkText:"Text",linkToolTip:"ToolTip",linkWebAddress:"Web address",search:"Search",createTable:"Створити таблицю",addColumnLeft:"Add column on the left",addColumnRight:"Add column on the right",addRowAbove:"Add row above",addRowBelow:"Add row below",deleteColumn:"Delete column",deleteRow:"Delete row",backColor:"Background color",deleteFile:'Are you sure you want to delete "{0}"?',deleteRow1:"Delete row",dialogButtonSeparator1:"or",dialogCancel1:"Cancel",dialogInsert1:"Insert",directoryNotFound:"A directory with this name was not found.",dropFilesHere:"drop files here to upload",emptyFolder:"Empty Folder",foreColor:"Color",invalidFileType:'The selected file "{0}" is not valid. Supported file types are {1}.',orderBy:"Arrange by:",orderByName:"Name",orderBySize:"Size",overwriteFile:'\'A file with name "{0}" already exists in the current directory. Do you want to overwrite it?',uploadFile:"Upload",formatting:"Format",viewHtml:"View HTML",dialogUpdate:"Update",insertFile:"Insert file"})),kendo.ui.Scheduler&&(kendo.ui.Scheduler.prototype.options.messages=e.extend(!0,kendo.ui.Scheduler.prototype.options.messages,{allDay:"all day",cancel:"Скасувати",editable:{confirmation:"Are you sure you want to delete this event?"},date:"Date",destroy:"Delete",editor:{allDayEvent:"All day event",description:"Description",editorTitle:"Event",end:"End",endTimezone:"End timezone",repeat:"Repeat",separateTimezones:"Use separate start and end time zones",start:"Start",startTimezone:"Start timezone",timezone:" ",timezoneEditorButton:"Time zone",timezoneEditorTitle:"Timezones",title:"Title",noTimezone:"No timezone"},event:"Event",recurrenceMessages:{deleteRecurring:"Do you want to delete only this event occurrence or the whole series?",deleteWindowOccurrence:"Delete current occurrence",deleteWindowSeries:"Delete the series",deleteWindowTitle:"Delete Recurring Item",editRecurring:"Do you want to edit only this event occurrence or the whole series?",editWindowOccurrence:"Edit current occurrence",editWindowSeries:"Edit the series",editWindowTitle:"Edit Recurring Item"},save:"Save",time:"Time",today:"Today",views:{agenda:"Agenda",day:"Day",month:"Month",week:"Week",workWeek:"Work Week"},deleteWindowTitle:"Delete event",showFullDay:"Show full day",showWorkDay:"Show business hours"})),kendo.ui.Upload&&(kendo.ui.Upload.prototype.options.localization=e.extend(!0,kendo.ui.Upload.prototype.options.localization,{cancel:"Cancel",dropFilesHere:"drop files here to upload",headerStatusUploaded:"Done",headerStatusUploading:"Uploading...",remove:"Remove",retry:"Retry",select:"Select...",statusFailed:"failed",statusUploaded:"uploaded",statusUploading:"uploading",uploadSelectedFiles:"Upload files"})),kendo.ui.Dialog&&(kendo.ui.Dialog.prototype.options.messages=e.extend(!0,kendo.ui.Dialog.prototype.options.localization,{close:"закінчати"})),kendo.ui.Alert&&(kendo.ui.Alert.prototype.options.messages=e.extend(!0,kendo.ui.Alert.prototype.options.localization,{okText:"OK"})),kendo.ui.Confirm&&(kendo.ui.Confirm.prototype.options.messages=e.extend(!0,kendo.ui.Confirm.prototype.options.localization,{okText:"OK",cancel:"Скасувати"})),kendo.ui.Prompt&&(kendo.ui.Prompt.prototype.options.messages=e.extend(!0,kendo.ui.Prompt.prototype.options.localization,{okText:"OK",cancel:"Скасувати"}))}(window.kendo.jQuery);
//# sourceMappingURL=kendo.messages.uk-UA.js.map
