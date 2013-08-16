jQuery('#MPage1').bind('pageinit',function(event){
 	jQuery('#MButton1').bind('click',MButton1Click);

});
        	function MEdit1_updatehidden(event)
            {
            	edit=$('#MEdit1').get(0);
                hidden=$('#MEdit1_hidden').get(0);
                hidden.value=edit.value;
                            }
        