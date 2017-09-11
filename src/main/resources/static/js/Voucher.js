function fetchCustomer(){
	var mobile= $("#vmobile").val();
	
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    
    $.ajax({
        url: '/customer/fetch?mobile='+mobile,
        type: 'GET',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (data) {
        	$("#cName").val(data.customerName);
        	$("#customerId").val(data.customerId);

        },
        error:function (err) {
            alert(err);
        }
    });
}

function saveVoucher(){
	var link =$("#vLink").attr("href");
	var customerId=$("#customerId").val();
	var voucherId=$("#voucherId").val();
	var mobile= $("#vmobile").val();
	var name= $("#cName").val();
	var v_vori=$("#v_vori").val();
	var v_ana=$("#v_ana").val();
	var v_roti=$("#v_roti").val();
	var v_point=$("#v_point").val();
	var totalWeight = ((v_vori*960)+(v_ana*60)+(v_roti*10)+v_point);
	var sTotalWeight = (v_vori+'.'+ v_ana+'.'+ v_roti+'.'+v_point);
	
	var voucherData = {
			'customerEntity':{
				'customerId':customerId,
				'mobile': mobile, 
				'customerName': name
				},
			'voucherId':voucherId,
			'v_vori':v_vori,
			'v_ana': v_ana,
			'v_roti': v_roti,
			'v_point': v_point,
			'totalWeight': totalWeight,
			'sTotalWeight' :sTotalWeight
			
        };
	 var JsonVoucherData = JSON.stringify(voucherData);

	
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    
    $.ajax({
        url: '/voucher-save',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        data: JsonVoucherData,
        success: function (data) {
        	$("#customerId").val(data.customerEntity.customerId);
        	$("#voucherId").val(data.voucherId);
        	$("#vLink").attr("href",link+data.voucherId);
        	$("#item").show();
        },
        error:function (err) {
            alert(err);
        }
    });
}