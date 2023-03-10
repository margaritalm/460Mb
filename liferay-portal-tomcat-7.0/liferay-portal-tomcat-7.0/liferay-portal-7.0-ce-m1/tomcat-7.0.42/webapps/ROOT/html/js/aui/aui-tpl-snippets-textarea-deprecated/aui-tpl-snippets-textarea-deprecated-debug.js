YUI.add('aui-tpl-snippets-textarea-deprecated', function (A, NAME) {

A.Template.register(
    'textarea', [
  '<tpl if="values.label !== undefined">',
   '<label class="{[A.TplSnippets.getClassName(values.auiLabelCssClass, values.labelCssClass)]}" for="{id}" id="{labelId}" name="{labelName}" style="{labelStyle}">{label}</label>',
  '</tpl>',
  '<textarea class="{[A.TplSnippets.getClassName(values.auiCssClass, values.cssClass)]}" <tpl if="values.disabled">disabled="disabled"</tpl> id="{id}" name="{name}" placeholder="{placeholder}" value="{valueAttr}" style="{style}">{value}</textarea>'
 ]
);


}, '3.0.0pr2', {"requires": ["aui-tpl-snippets-base-deprecated"]});
