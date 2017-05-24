"use strict";
jQuery(document).ready(function($) {

    // Back to top
    var offset = 300,
        offset_opacity = 1200,
        scroll_top_duration = 700,
        $back_to_top = $('.cd-top');

    $(window).scroll(function(){
        ( $(this).scrollTop() > offset ) ? $back_to_top.addClass('cd-is-visible') : $back_to_top.removeClass('cd-is-visible cd-fade-out');
        if( $(this).scrollTop() > offset_opacity ) {
            $back_to_top.addClass('cd-fade-out');
        }
    });

    $back_to_top.on('click', function(event){
        event.preventDefault();
        $('body,html').animate({
                scrollTop: 0
            }, scroll_top_duration
        );
    });

    // Left menu block toggle
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });

    // Show nice tables
    $('#dataTable').DataTable({
        responsive: true,
        language: {
            url: "js/dataTables/dataTables.korean.lg"
        },
        "order": [[ 1, "desc" ]]

    });

    // Tooltipe
    $('[data-toggle="tooltip"]').tooltip();

    // timeago
    $("time.timeago").timeago();

    // Project add/edit from validation
    $('#customerSOOID').keydown(function (event) {
        // Разрешаем: backspace, delete, tab и escape
        if (event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 27 ||
            // Разрешаем: Ctrl+A
            (event.keyCode == 65 && event.ctrlKey === true) ||
            // Разрешаем: home, end, влево, вправо
            (event.keyCode >= 35 && event.keyCode <= 39)) {
            // Ничего не делаем
            return;
        }
        else {
            // Обеждаемся, что это цифра, и останавливаем событие keypress
            if ((event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) {
                event.preventDefault();
            }
        }
    });

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

    // Delete confirm
    function sebSweetConfirm(originLink){
        swal({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#00BFF4',
            cancelButtonColor: '#aaa',
            confirmButtonText: 'Yes, delete it!'
        }).then(function(isConfirm){
            if (isConfirm) {
                window.location.href = originLink;
            }
        })
    }

    $('.deleteConfirm').click(function(event){
        event.preventDefault();
        var originLink = $(this).attr("href");
        sebSweetConfirm(originLink);
    });

    // Notices
    $(".tasks-box a").each(function () {
        var notice_id = $(this).attr('id');

        $("#" + notice_id).click(function() {
            if ( $("#" + notice_id).hasClass("active")) {
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

// CKEDITOR show
CKEDITOR.replace('editor', {
    toolbar : 'Basic',
    width : '100%',
    height : '250'
});
