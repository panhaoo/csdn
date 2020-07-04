/**
 * @license Copyright (c) 2003-2018, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	config.language = 'zh-cn';
	config.height = 350;   
	config.autoParagraph = false;  
	config.allowedContent=true;
	config.toolbar = 'Basic';
	config.toolbar_Basic =[

    ['Source', 'Bold', 'Italic','Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord','Preview','Undo','Redo','Link','Image','Table','Smiley','Font','FontSize','TextColor','BGColor','Html5video','pbckcode'],
  
    ];
	config.extraPlugins = 'html5video,widget,widgetselection,clipboard,lineutils,pbckcode';
	config.pbckcode = {
	    modes: [['HTML', 'html'], ['CSS', 'css'], ['PHP', 'php'], ['JS', 'javascript']],
	    tab_size: '4'
	};
	config.resize_enabled = true;
	config.disallowedContent = 'img{width,height};img[width,height]';
config.enterMode = CKEDITOR.ENTER_P;
config.shiftEnterMode = CKEDITOR.ENTER_BR; 


	// 过滤粘贴内容
	config.forcePasteAsPlainText = false;

	config.magicline_color = '#ccc';

	config.magicline_everywhere = true;

	config.fontSize_sizes = '16px;18px';
	config.removePlugins = 'elementspath';
	config.removeButtons = 'Paste,Save,/,Templates,NewPage,Language,CopyFormatting,Anchor,Underline,Strike,Subscript,Superscript,About,ShowBlocks,Maximize,Styles,PageBreak,SpecialChar,HorizontalRule,Flash,Anchor,Unlink,BidiLtr,BidiRtl,CreateDiv,Indent,Outdent,HiddenField,ImageButton,Button,Select,Textarea,TextField,Radio,Checkbox,Form,SelectAll,Replace,Find,Scayt,SpellChecker,Print';

};
