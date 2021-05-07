
function isValidFormResearch()
{
	if($.trim($("#txtResearchName").val())=="")
	{ return "enter Research name"; }
	return "true/false";
}

//--Research  save/update
$(document).on("click","#btnSave",function()
{
			var result = isValidFormResearch();
			if(result=="true")
				{ $("#formResearch").submit(); }
			
			else
				{ $("#divStsMsgResearch").html(result); }
				
});

//--edit
$(document).on("click","#btnEdit",function()
{
	$("#hidMode").val(update);
	$("#hidID").val($(this).attr("param"));
	$("#txtResearchName").val($(this).closest("tr").find('td:eq(1)').text());
	$("#txtAuthor1").val($(this).closest("tr").find('td:eq(2)').text());
	$("#txtAuthor2").val($(this).closest("tr").find('td:eq(2)').text());
	$("#txtAuthor3").val($(this).closest("tr").find('td:eq(2)').text());
	$("#txtField").val($(this).closest("tr").find('td:eq(2)').text());
	$("#txtPublisher").val($(this).closest("tr").find('td:eq(2)').text());
	$("#txtPublishYear").val($(this).closest("tr").find('td:eq(2)').text());
	$("#txtBudget").val($(this).closest("tr").find('td:eq(2)').text());
	
	
});
//--Remove
$(document).on("click","#btnRemove", function()
{
	$("#hidMode").val("remove");
	$("#hidID").val($(this).attr("param"));
	var res = confirm("are you sure?");
		if(res == true){
			$("#formResearch").submit();
		}


});
