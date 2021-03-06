var main = {
    init : function () {
        var _this = this;
        $('#btn-change').on('click', function() {
            _this.update();
        });
        $('#newPassword1').on('change', function() {
            _this.pwd1Chk();
            _this.pwd2Chk();
        });
        $('#newPassword2').on('change', function() {
            _this.pwd2Chk();
        });
    },
    update : function () {
        var _this = this;
        if (_this.pwd1Chk() && _this.pwd2Chk())
        {
            var data = {
                oldPassword: $('#password').val(),
                newPassword: $('#newPassword1').val()
            };

            $('#btn-signup').prop('disabled', true);
            $('#btn-signup').prop('value', "처리중...");

            $.ajax({
                type: 'POST',
                url: '/api/users/updatePassword',
                dataType: 'text',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data),
                success: function() {
                    Swal.fire({
                        title: "비밀번호가 변경되었습니다.",
                        text: "다시 로그인해주세요.",
                        icon: "success"
                    })
                    .then(() =>{
                        window.location.href='/logout';
                    });
                },
                error: function(request) {
                    $('#btn-signup').prop('disabled', false);
                    $('#btn-signup').prop('value', "수정");
                    var outputMessage = JSON.parse(request.responseText).outputMessage;
                    Swal.fire({
                        title: outputMessage,
                        icon: "error"
                    });
                }
            });
        } else {
            Swal.fire({
                title: "양식에 맞지 않습니다.",
                text: "다시 작성해주세요.",
                icon: "error"
            });
        }
    },
    pwd1Chk : function () {
        var _this = this;
        var pwd1 = $('#newPassword1').val();

        $('.pwd1_blank').css("display", "none");

        if(_this.isPassword(pwd1) == true) {
            $('.pwd1_check_success').css("display", "inline-block");
            $('.pwd1_check_fail').css("display", "none");
            return true;
        } else {
            $('.pwd1_check_fail').css("display", "inline-block");
            $('.pwd1_check_success').css("display", "none");
            return false;
        }
        return true;
    },
    pwd2Chk : function () {
        var pwd1 = $('#newPassword1').val();
        var pwd2 = $('#newPassword2').val();

        $('.pwd2_blank').css("display", "none");

        if(pwd1 == pwd2) {
            $('.pwd2_check_success').css("display", "inline-block");
            $('.pwd2_check_fail').css("display", "none");
            return true;
        } else {
            $('.pwd2_check_fail').css("display", "inline-block");
            $('.pwd2_check_success').css("display", "none");
            return false;
        }
        return true;
    },
    isPassword : function (pwd) {
        var regExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/;
        return regExp.test(pwd);
    }
};

main.init();