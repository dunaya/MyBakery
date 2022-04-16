package com.example.bakery.SERVER.models;

import com.example.bakery.SERVER.API.DTO.ClientDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import javax.persistence.*;


@SqlResultSetMapping(
        name = "userMapping",
        classes = @ConstructorResult(
                targetClass = ClientDTO.class,
                columns = {
                        @ColumnResult(name = "id", type=Long.class),
                        @ColumnResult(name = "username", type=String.class),
                        @ColumnResult(name ="surname", type=String.class),
                        @ColumnResult(name ="login", type=String.class),
                        @ColumnResult(name ="password", type=String.class),
                        @ColumnResult(name ="link", type=String.class),
                }
        )
)

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ApiModelProperty("client id")
    public Long id;

    @NotNull
    @Column(name = "username", length = 30)
    @ApiModelProperty("client username")
    public String name;

    @NotNull
    @Column(name = "surname", length = 30)
    @ApiModelProperty("client surname")
    public String surname;

    @NotNull
    @Column(name = "login", length = 30)
    @ApiModelProperty("client login")
    public String login;


    @NotNull
    @Column(name = "password", length = 30)
    @ApiModelProperty("hash of password")
    @JsonIgnore
    public String password;

    @NotNull
    @Column(name = "type", length = 30)
    @ApiModelProperty("client")
    public String type;

    @NotNull
    @Column(name = "link", length = 30)
    @ApiModelProperty("hash of password")
    public String link;

    @NotNull
    @Column(name = "baker", length = 30)
    @ApiModelProperty("your baker")
    public String yourBaker;

}
