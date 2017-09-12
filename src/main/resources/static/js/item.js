$(document).ready(function(){
	$('#saveItem').click(function () {
		console.log("shuvo");
		 var itemRowIndex=$('#itemTable tr:last').attr('id').split("itemTabRowId_").join("");
		 		itemRowIndex=parseInt(itemRowIndex);
		 		itemRowIndex+=1;
		 
		 var itemId			=	$("#itemId").val();
		 var voucherId		=	$("#voucherId").val();
		 var chainType		=	$("#itemChain").val();
		 var machineType	=	$("#itemMachine").val();
		 var inch			=	$("#item_inch").val();
		 var vori			=	$("#item_vori").val();
		 var ana			=	$("#item_ana").val();
		 var roti			=	$("#item_roti").val();
		 var point			=	$("#item_point").val();
		 var weight			=	((vori*960)+(ana*60)+(roti*10)+(point*1));
		 var sWeight		=	(vori+'.'+ana+'.'+roti+'.'+point);
		 var estCutPoint 	=	((($("#c_vori").val())*960)+
				 				 (($("#c_ana").val())*60)+
				 				 (($("#c_roti").val())*10)+
				 				 (($("#c_point").val()*1)));
		 var is_editItem 	=	$("#is_editItem").text();
		 var rowIndexItem 	=	$("#rowIndexItem").text();
		 
		 var itemData={
				 'itemId' : itemId,
				 'voucherEntity' 	: {'voucherId': voucherId},
				 'chainTypeEntity'	: {'chainId' : chainType},
				 'machineTypeEntity' : {'machineId' : machineType},
				 'estInch' : inch,
				 'vori' : vori,
				 'ana' : ana,
				 'roti' : roti,
				 'point' : point,
				 'weight' : weight,
				 'sWeight':sWeight,
				 'estCutPoint' :estCutPoint
				 
		 };

		 console.log(itemData);
		 var JsonItem = JSON.stringify(itemData);
		 /*var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");*/
	    $.ajax({
	           url: '/save-item',
	           type: 'POST',
	           contentType: 'application/json; charset=utf-8',
	           dataType: 'json',
	           data: JsonItem,
	           /*beforeSend: function (xhr) {
	               xhr.setRequestHeader(header, token);

	           },*/
	           success: function (data) {
	               if (is_editItem == 0) {
	                   var newRow = '<tr id="itemTabRowId_' + itemRowIndex +'">' +
	                   '<td><label id="item_chainType_' + itemRowIndex + '">' + data.chainTypeEntity.chainName + '</label>' +
	                   '<label id="itemIdd_' + itemRowIndex + '"style="display: none">' + data.itemId + '</label>' +
	                   
	                   '<label id="item_chain_hid_' + itemRowIndex + '"style="display: none">' + data.chainTypeEntity.chainId + '</label>' +
	                   '<label id="item_machine_hid_' + itemRowIndex + '"style="display: none">' + data.machineTypeEntity.machineId + '</label>' +
	                   '<label id="item_vorii_' + itemRowIndex + '"style="display: none">' + data.vori + '</label>' +
	                   '<label id="item_anaa_' + itemRowIndex + '"style="display: none">' + data.ana + '</label>' +
	                   '<label id="item_rotii_' + itemRowIndex + '"style="display: none">' + data.roti + '</label>' +
	                   '<label id="item_pointt_' + itemRowIndex + '"style="display: none">' + data.point + '</label>' +
	                   
	                   '<td><label id="item_machineType_' + itemRowIndex + '">' + data.machineTypeEntity.machineName + '</label></td>' +
	                   '<td><label id="item_inch_' + itemRowIndex + '">' + data.estInch + '</label></td>' +
	                   '<td><label id="item_weight_' + itemRowIndex + '">' + data.vori+"." + data.ana+"."
	                   + data.roti+"."+ data.point + '</label></td>' +
	                   '<td><button href="#" class="btn-success" onclick="editItem('+itemRowIndex +')" data-toggle="modal" data-target="#modal-item"><i class="fa fa-pencil" ></i></button>' +
	                   '<button href="#" onclick="deleteItem(this,' +itemRowIndex + ')"><i class="fa fa-times"></i></button></td>' +
	                   '</tr>';
	                   $("#itemTable").append(newRow);
	               }else{
	            	   $('#itemIdd_'+rowIndexItem).text(data.itemId);
	                   $('#item_voucherId_'+rowIndexItem).text(data.voucherEntity.voucherId);
	                   $('#item_chain_hid_' + rowIndexItem).text(data.chainTypeEntity.chainId);
	                   $('#item_machine_hid_' + rowIndexItem).text(data.machineTypeEntity.machineId);
	                   $('#item_chainType_'+rowIndexItem).text(data.chainTypeEntity.chainName);
	                   $('#item_machineType_'+rowIndexItem).text(data.machineTypeEntity.machineName);
	                   $('#item_inch_'+rowIndexItem).text(data.estInch);
	                   $('#item_weight_'+rowIndexItem).text( data.vori+"." + data.ana+"."
	    	                   + data.roti+"."+ data.point);
	               }
	               resetItem();
	               $('#saveItem').attr("data-dismiss","modal");
	           },
	           error:function (err) {
	               alert(err);
	           }
	       }); 
	});
	
});

function editItem(itemRowIndex) {
	var itemId					=		$('#itemIdd_'+itemRowIndex).text();
	var chainType				=		$('#item_chain_hid_'+itemRowIndex).text();
	var machineType				=		$('#item_machine_hid_'+itemRowIndex).text();
    var inch					=		$('#item_inch_'+itemRowIndex).text();
    var vori					=		$('#item_vorii_'+itemRowIndex).text();
    var ana						=		$('#item_anaa_'+itemRowIndex).text();
    var roti					=		$('#item_rotii_'+itemRowIndex).text();
    var point					=		$('#item_pointt_'+itemRowIndex).text();

    $("#itemId").val(itemId);	 
	  $("#itemChain").val(chainType);
	  $("#itemMachine").val(machineType);
	  $("#item_inch").val(inch);
	  $("#item_vori").val(vori);
	  $("#item_ana").val(ana);
	  $("#item_roti").val(roti);
	  $("#item_point").val(point);
	  $("#is_editItem").text('1');
      $("#rowIndexItem").text(itemRowIndex);

}



function resetItem() {
	  $("#itemChain").val('');
	  $("#itemMachine").val('');
	  $("#item_inch").val('');
	  $("#item_vori").val('');
	  $("#item_ana").val('');
	  $("#item_roti").val('');
	  $("#item_point").val('');
	  $("#is_editItem").text('0');
	  $("#rowIndexItem").text('');
}

function deleteItem(i,itemRowIndex){
    if(confirm('Want to delete')){
    	var itemId		=		$('#itemIdd_'+itemRowIndex).text();
    	console.log(itemId);
    	var itemData={'itemId' : itemId};
		var JsonItem = JSON.stringify(itemData);

        $.ajax({
        	 url: '/delete-item',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            data: JsonItem,
            /*beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);

            },*/
            success: function (data) {
                alert("Deleted");
                console.log(data);
                removeRow(i);
            },error: function (data){
            	console.log(data);
            }
        });

    }

}

function removeRow(r) {
    var i = r.parentNode.parentNode.rowIndex;
    document.getElementById("itemTable").deleteRow(i);
}
