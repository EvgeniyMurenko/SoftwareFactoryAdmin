/*globalPath = "http://52.57.116.160:8080";*/
/*globalPath = "http://a.sofac.kr";*/
globalPath = "http://localhost:8080";

jQuery(document).ready(function ($) {


    $('.btn-submit').click(function() {

        var form = $(this).parents('form:first');

        form.submit(function () {
            var $submitButton =  $( ".btn-submit" );

            $submitButton.prop("disabled", true);
            $submitButton.text("Please wait...");
        });

    });



    $(".js-example-basic-multiple").select2();

    // Back to top
    var offset = 300,
        offset_opacity = 1200,
        scroll_top_duration = 700,
        $back_to_top = $('.cd-top');

    $(window).scroll(function () {
        ( $(this).scrollTop() > offset ) ? $back_to_top.addClass('cd-is-visible') : $back_to_top.removeClass('cd-is-visible cd-fade-out');
        if ($(this).scrollTop() > offset_opacity) {
            $back_to_top.addClass('cd-fade-out');
        }
    });

    $back_to_top.on('click', function (event) {
        event.preventDefault();
        $('body,html').animate({
                scrollTop: 0
            }, scroll_top_duration
        );
    });

    $('.rating-loading').rating({displayOnly: true, step: 0.5, size: "xs", min: 0, max: 5, stars: 5});

    // Left menu block toggle
    $("#menu-toggle").click(function (e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });

    // Show nice tables
    $('#dataTable').DataTable({
        responsive: true
    });

    // Tooltipe
    $('[data-toggle="tooltip"]').tooltip();

    // timeago
    $(".timeago").timeago();

    // datetimepicker
    $('#datetimepicker').datetimepicker({
        format: 'YYYY-MM-DD HH:mm'
    });
    $('#datetimepicker1').datetimepicker({
        format: 'YYYY-MM-DD HH:mm',
        useCurrent: false //Important! See issue #1075
    });
    $("#datetimepicker").on("dp.change", function (e) {
        $('#datetimepicker1').data("DateTimePicker").minDate(e.date);
    });
    $("#datetimepicker1").on("dp.change", function (e) {
        $('#datetimepicker').data("DateTimePicker").maxDate(e.date);
    });

    // Case upload file
    $("#chatUpload").fileinput();
    $("#uploadFile").fileinput();
    $("#avatarUpload").fileinput({
        maxFileCount: 1
    });

    // Delete confirm
    function sebSweetConfirm(originLink) {
        swal({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#00BFF4',
            cancelButtonColor: '#aaa',
            confirmButtonText: 'Yes, delete it!'
        }).then(function (isConfirm) {
            if (isConfirm) {
                window.location.href = originLink;
            }
        })
    }

    $('.deleteConfirm').click(function (event) {
        event.preventDefault();
        var originLink = $(this).attr("href");
        sebSweetConfirm(originLink);
    });

    // Notices
    $(".tasks-box a").each(function () {
        var notice_id = $(this).attr('id');

        $("#" + notice_id).click(function () {
            if ($("#" + notice_id).hasClass("active")) {
                $("#" + notice_id).removeClass("active");
                $("#" + notice_id + " i.fa").removeClass("fa-chevron-up");
                $("#" + notice_id + " i.fa").addClass("fa-chevron-down");
            } else {
                $("#" + notice_id).addClass("active");
                $("#" + notice_id + " i.fa").removeClass("fa-chevron-down");
                $("#" + notice_id + " i.fa").addClass("fa-chevron-up");
            }

            $("#box_" + notice_id).toggle();
        });
    });
});

function getCustomerProject(index) {
    $.ajax({
        type: "GET",
        data: "index=" + index,
        url: globalPath+"/customer-mm/show-customer-project/",
        dataType: "json",
        success: function (data) {
            if (data.customerInfo != '') {


                $('#customerSoid_json').text(data.customerSoid_json);

                $('#showInfo1').modal({
                    backdrop: 'static',
                    keyboard: true
                });
                document.getElementById('modalTable').innerHTML = data.stringBuilder;
                document.getElementById('customerSoid').innerHTML = data.customerSoid;
            }
        }
    });
}

function getCustomerInfo(customerId) {
    $.ajax({
        type: "GET",
        data: "customerId=" + customerId,
        url: globalPath+"/project-mm/show-customer-info/",
        dataType: "json",
        success: function (data) {
            // tableWorkers
            // countPages
            if (data.customerInfo != '') {

                $('#customerSoid_json').text(data.customerSoid);
                $('#customerCompany_json').text(data.customerCompany);
                $('#customerWebsite_json').text(data.customerWebsite);
                $('#customerName_json').text(data.customerName);
                $('#customerEmail_json').text(data.customerEmail);
                $('#customerPhone_json').text(data.customerPhone);
                $('#customerAccount_json').text(data.customerAccount);
                $('#customerDirectorsName_json').text(data.customerDirectorsName);
                $('#customerDirectorsEmail_json').text(data.customerDirectorsEmail);
                $('#customerDirectorsPhone_json').text(data.customerDirectorsPhone);
                $('#customerCompanyType_json').text(data.customerCompanyType);
                $('#customerAddress_json').text(data.customerAddress);
                $('#myModalInfo').modal({
                    backdrop: 'static',
                    keyboard: true
                });
                document.getElementById('modalTable').innerHTML = data.stringBuilder;
            }
        },
    });
}

function getTranslateComment(commentId) {
    $.ajax({
        type: "GET",
        data: "commentId=" + commentId,
        url: globalPath+"/group/get-translate-comment/",
        dataType: "json",
        success: function (data) {
            if (data.translateComment != '') {
                $('.linkToHide'+commentId).remove();
                document.getElementById('commentToTranslate'+commentId).innerHTML = data.translateComment;
                document.getElementById('linkToHide'+commentId).style.display='none';
            }
        }
    });
}


function getPostTextToTranslate(postId) {
    $.ajax({
        type: "GET",
        data: "postId=" + postId,
        url: globalPath+"/group/get-post-text/",
        dataType: "json",
        success: function (data) {
            if (data.textToTranslate != '') {
                $('#translatePost').modal({
                    backdrop: 'static',
                    keyboard: true
                });
                document.getElementById('textToTranslate').innerHTML = data.textToTranslate;
                document.getElementById('postId').innerHTML = data.postId_json;
            }
        }
    });
}

function getPostEdit(postId) {
    $.ajax({
        type: "GET",
        data: "postId=" + postId,
        url: globalPath+"/group/get-post-edit/",
        dataType: "json",
        success: function (data) {
            if (data.stringBuilderPostId != '') {
                $('#addPost').modal({
                    backdrop: 'static',
                    keyboard: true
                });
                CKEDITOR.instances.textEdit.setData(''+data.postTextOriginal);
                document.getElementById('fileAttach').innerHTML = data.stringBuilderFileAttach;
                document.getElementById('postIdToEdit').innerHTML = data.stringBuilderPostId;
            }
        }
    });
}

function deleteFile(fileNmae, postId) {
    $.ajax({
        type: "GET",
        data:{"fileNmae": fileNmae, "postId":postId},
        url: globalPath+"/group/delete-file/",
        dataType: "json",
        success: function (data) {
            if (data.postId != '') {
                /*$('#addPost').modal({
                 backdrop: 'static',
                 keyboard: true
                 });
                 document.getElementById('postIdToEdit').innerHTML = data.stringBuilderAdd;*/
                getPostEdit(postId);
            }
        }
    });
}

function addNewPost(groupType) {
    $.ajax({
        type: "GET",
        data: "postId=" + postId,
        url: globalPath+"/group/add-new-post/"+groupType+"/",
        dataType: "json",
        success: function (data) {
            if (data.stringBuilderAdd != '') {
                $('#addPost').modal({
                    backdrop: 'static',
                    keyboard: true
                });
                document.getElementById('postIdToEdit').innerHTML = data.stringBuilderAdd;
            }
        }
    });
}

function deleteComment(commentId, postId) {
    $.ajax({
        type: "GET",
        data:{"commentId": commentId, "postId":postId},
        url: globalPath+"/group/delete-comment/",
        dataType: "json",
        success: function (data) {
            if (data.countComments != '') {
                document.getElementById('commetn-'+commentId).style.display='none';
                /*document.getElementById('oldCountComments-'+postId).style.display='none';

                document.getElementById('countComments').innerHTML = data.countComments;*/
            }
        }
    });
}
function getTextCommentEdit(commentId) {
    $.ajax({
        type: "GET",
        data: "commentId=" + commentId,
        url: globalPath+"/group/get-comment-text-to-edit/",
        dataType: "json",
        success: function (data) {
            if (data.stringBuilderTextComment != '') {
                document.getElementById('commentText'+commentId).style.display='none';
                document.getElementById('editComment'+commentId).style.display='block';
                document.getElementById('translateComment'+commentId).style.display='none';

                document.getElementById('textToEdit'+commentId).innerHTML = data.stringBuilderTextComment;
            }
        }
    });
}


function clouseEditComment(commentId) {
    document.getElementById('commentText'+commentId).style.display='block';
    document.getElementById('translateComment'+commentId).style.display='block';
    document.getElementById('editComment'+commentId).style.display='none';

}

function updateComment(commentId) {
    var newTextComment = $('#newCommentText'+commentId).val();
    $.ajax({
        type: "GET",
        data:{"commentId": commentId, "newTextComment":newTextComment},
        url: globalPath+"/group/update-comment/",
        dataType: "json",
        success: function (data) {
            if (data.succes != '') {
                document.getElementById('commentText'+commentId).style.display='block';
                document.getElementById('translateComment'+commentId).style.display='block';
                document.getElementById('editComment'+commentId).style.display='none';
                document.getElementById('commentText'+commentId).innerHTML = newTextComment;
            }
        }
    });
}

function translateCaseMessage(messageId) {
    $.ajax({
        type: "GET",
        data: "messageId=" + messageId,
        url: globalPath+"/cases/get-messate-to-translate/",
        dataType: "json",
        success: function (data) {
            if (data.textToTranslate != '') {
                $('#translateMessage').modal({
                    backdrop: 'static',
                    keyboard: true
                });
                document.getElementById('messageTextToTranslate').innerHTML = data.textToTranslate;
                document.getElementById('messageId').innerHTML = data.stringBuilderMessageId;
            }
        }
    });
}

/*var show;
 function hidetxt(type){
 var param=document.getElementById(type);
 if(param.style.display == "none") {
 if(show) show.style.display = "none";
 param.style.display = "block";
 show = param;
 }else param.style.display = "none"
 }*/

// CKEDITOR show
CKEDITOR.replace('editor', {
    toolbar: 'Basic',
    width: '100%',
    height: '250'
});

// CKEDITOR show
CKEDITOR.replace('textEdit', {
    toolbar: 'Basic',
    width: '100%',
    height: '250'
});


