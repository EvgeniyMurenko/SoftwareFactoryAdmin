"use strict";
jQuery(document).ready(function ($) {

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

    $('#rating').rating({displayOnly: true, step: 0.5, size: "xs", min: 0, max: 5, stars: 5});

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
    $("time.timeago").timeago();

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
        /*url: "http://a.sofac.kr/customer-mm/show-customer-project/",*/
        url: "http://localhost:8080/customer-mm/show-customer-project/",
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
        /*url: "http://a.sofac.kr/project-mm/show-customer-info/",*/
        url: "http://localhost:8080/project-mm/show-customer-info/",
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

// CKEDITOR show
CKEDITOR.replace('editor', {
    toolbar: 'Basic',
    width: '100%',
    height: '250'
});
