package com.still_a_long_way25.authentification.form;

import com.still_a_long_way25.authentification.type.Role;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by y-ok on 2017/05/02.
 */
@Data
public class LoginUserCreateForm {

    @NotEmpty
    public String email;

    @NotEmpty
    public String password;

    @NotEmpty
    public String passwordRepeated;

    @NotNull
    public Role role = Role.USER;
}
