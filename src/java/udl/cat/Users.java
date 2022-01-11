/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udl.cat;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gianfranco Reyes
 */
@Entity
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByNameUser", query = "SELECT u FROM Users u WHERE u.nameUser = :nameUser")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "NAME_USER")
    private String nameUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumn(name = "ID_CONTENT", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Content idContent;
    @JoinColumn(name = "ID_NODE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Node idNode;

    public Users() {
    }

    public Users(String nameUser) {
        this.nameUser = nameUser;
    }

    public Users(String nameUser, String password) {
        this.nameUser = nameUser;
        this.password = password;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Content getIdContent() {
        return idContent;
    }

    public void setIdContent(Content idContent) {
        this.idContent = idContent;
    }

    public Node getIdNode() {
        return idNode;
    }

    public void setIdNode(Node idNode) {
        this.idNode = idNode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nameUser != null ? nameUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.nameUser == null && other.nameUser != null) || (this.nameUser != null && !this.nameUser.equals(other.nameUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "udl.cat.Users[ nameUser=" + nameUser + " ]";
    }
    
}
