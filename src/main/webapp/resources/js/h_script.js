// ��ȿ�� �˻�


jQuery(function (){ 
	jQuery('#save').click(function() { 
		var subject = jQuery('#form #subject').val(); 
		if (subject == '') { alert('������ �Է��ϼ���'); 
		return false; 
		}
		var subject = jQuery('#form #subject').val(); 
		if (subject == '[����Խ���]') { alert('������ �Է��ϼ���'); 
		return false; 
		}
		var subject = jQuery('#form #subject').val(); 
		if (subject == '[�����Խ���]') { alert('������ �Է��ϼ���'); 
		return false; 
		}
		var subject = jQuery('#form #subject').val(); 
		if (subject == '[���ӰԽ���]') { alert('������ �Է��ϼ���'); 
		return false; 
		}
		var subject = jQuery('#form #subject').val(); 
		if (subject == '[��аԽ���]') { alert('������ �Է��ϼ���'); 
		return false; 
		}
		var subject = jQuery('#form #subject').val(); 
		if (subject == '[����ũ���Ͽ�]') { alert('������ �Է��ϼ���'); 
		return false; 
		}
		var content = jQuery('#form #banks').val(); 
		if (content == '') { alert('������� �Է��ϼ���'); 
		return false; 
		}
		var content = jQuery('#form #re_productname').val(); 
		if (content == '') { alert('��ǰ���� �Է��ϼ���'); 
		return false; 
		}
		var content = jQuery('#form #content').val(); 
		if (content == '') { alert('������ �Է��ϼ���'); 
		return false; 
		}
		
		jQuery('#save').submit(); 
	}); 
		
	jQuery('#search').click(function() { 
		var searchStr = jQuery('#searchf #searchStr').val(); 
		if (searchStr == '') { alert('�˻�� �Է��ϼ���'); 
		return false; 
		}
		jQuery('#find').submit(); 
		}); 
		
		
	}); 