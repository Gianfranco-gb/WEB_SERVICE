/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udl.cat;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gianfranco Reyes
 */
@Entity
@Table(name = "CONTENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Content.findAll", query = "SELECT c FROM Content c")
    , @NamedQuery(name = "Content.findById", query = "SELECT c FROM Content c WHERE c.id = :id")
    , @NamedQuery(name = "Content.findByTitle", query = "SELECT c FROM Content c WHERE c.title = :title")
    , @NamedQuery(name = "Content.findByDescription", query = "SELECT c FROM Content c WHERE c.description = :description")
    , @NamedQuery(name = "Content.findByNode", query = "SELECT c FROM Content c WHERE c.node = :node")})
public class Content implements Serializable {

    @Size(max = 500)
    @Column(name = "KEYWORDS")
    private String keywords;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "NODE")
    private String node;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContent")
    private Collection<Users> usersCollection;

    public Content() {
    }

    public Content(Integer id) {
        this.id = id;
    }

    public Content(Integer id, String title, String description, String node) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.node = node;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Content)) {
            return false;
        }
        Content other = (Content) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String string_content = "Datos del archivo: "+ id + "\n";
        string_content = string_content.concat("Title: " + title + "\n");
        string_content = string_content.concat("Description: " + description + "\n");
        string_content = string_content.concat("Nodo: " + node + "\n");
        string_content = string_content.concat("Keywords: " + keywords + "\n");
        string_content = string_content.concat("----------------------------------\n");
        return string_content;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    
}
