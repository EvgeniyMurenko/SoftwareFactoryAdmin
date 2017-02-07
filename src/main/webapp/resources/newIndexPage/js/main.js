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
                scrollTop: 0 ,
            }, scroll_top_duration
        );
    });

    // Portfolio slider
    $('#portfolio').carousel({
        interval: false,
    });

    // upload file
    $("#input-repl-2").fileinput({
        uploadUrl: "/file-upload-batch/2",
        autoReplace: true,
        maxFileCount: 5,
        //allowedFileExtensions: ["jpg", "jpeg", "png", "gif"]
    });

    // Authorization from validation
    $('#authorizationForm').formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            email: {
                validators: {
                    notEmpty: {
                        message: '이메일은 필수 입력 항목 입니다.'
                    },
                    emailAddress: {
                        enabled: false,
                    },
                    regexp: {
                        regexp: /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i,
                        message: '이메일이 잘못 입력 되었습니다.'
                    },
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '암호는 필수 입력 항목입니다. (공백은 허용하지 않습니다)'
                    },
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: '암호는ㄴ 3자 이상 입력해야 하며 20자 입력 할 수 있습니다.'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: '암호는 알파벳, 숫자, 특수문자 (“.” , “_”)만 쓸 수 있습니다.'
                    }
                }
            }
        }
    });

    // Authorization from validation
    $('#estimationForm').formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            email: {
                validators: {
                    notEmpty: {
                        message: '이메일은 필수 입력 항목 입니다.'
                    },
                    emailAddress: {
                        enabled: false,
                    },
                    regexp: {
                        regexp: /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i,
                        message: '이메일이 잘못 입력 되었습니다.'
                    },
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '암호는 필수 입력 항목입니다. (공백은 허용하지 않습니다)'
                    },
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: '암호는ㄴ 3자 이상 입력해야 하며 20자 입력 할 수 있습니다.'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: '암호는 알파벳, 숫자, 특수문자 (“.” , “_”)만 쓸 수 있습니다.'
                    }
                }
            },
            name: {
                validators: {
                    notEmpty: {
                        message: '항목을 채워 주세요 (이름 또는 별명)'
                    }
                }
            },
            phone: {
                validators: {
                    notEmpty: {
                        message: '입력-A 바랍니다 축.'
                    },
                    regexp: {
                        message: '올바른 형식으로 전화 번호를 입력하십시오.'
                    }
                }
            },
            message: {
                validators: {
                    notEmpty: {
                        message: '항목을 채워 주세요.'
                    }
                }
            }
        }
    });
});