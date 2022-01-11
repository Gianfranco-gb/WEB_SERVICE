/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udl.cat.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import udl.cat.Content;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
/**
 *
 * @author Gianfranco Reyes
 */
@Stateless
@Path("udl.cat.content")
public class ContentFacadeREST extends AbstractFacade<Content> {

    @PersistenceContext(unitName = "Node_ProjectPU")
    private EntityManager em;

    public ContentFacadeREST() {
        super(Content.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Content entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Content entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Content find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Content> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Content> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("search_description/{description}")
    @Produces({MediaType.APPLICATION_XML})
    public List<Content> findByDescription(@PathParam("description") String desc) {
        List<Content> get_all_content = new ArrayList();
        if(desc.contains(",")){
            String[] all_desc =desc.split(",");
            for(String desc_splitted : all_desc){
                desc_splitted = desc_splitted.trim();
                List<Content> list_content = super.findAll();
                for(Content cont: list_content){
                    String desc_cont = cont.getDescription();
                    if(desc_cont.contains(desc_splitted)){
                        if(!get_all_content.contains(cont))
                            get_all_content.add(cont);
                    }
                } 
            }
            return get_all_content;
        }else{
            List<Content> list_content = super.findAll();
            for(Content cont: list_content){
                String desc_cont = cont.getDescription();
                if(desc_cont.contains(desc)){
                    get_all_content.add(cont);
                }
            }
            return get_all_content; 
        }
    }
    
    @GET
    @Path("search_title/{title}")
    @Produces({MediaType.APPLICATION_XML})
    public List<Content> findByTitle(@PathParam("title") String title) {
        List<Content> get_all_content = new ArrayList();
        if(title.contains(",")){
            String[] all_title =title.split(",");
            for(String title_splitted : all_title){
                title_splitted = title_splitted.trim();
                List<Content> list_content = super.findAll();
                for(Content cont: list_content){
                    String desc_cont = cont.getTitle();
                    if(desc_cont.contains(title_splitted)){
                        if(!get_all_content.contains(cont))
                            get_all_content.add(cont);
                    }
                } 
            }
            return get_all_content;
        }else{ 
            List<Content> list_content = super.findAll();
            for(Content cont: list_content){
                String title_cont = cont.getTitle();
                if(title_cont.contains(title)){
                    get_all_content.add(cont);
                
                }
            }
            return get_all_content; 
        }
    }
    
    
    @GET
    @Path("search_keyword/{keyword}")
    @Produces({MediaType.APPLICATION_XML})
    public List<Content> findByKeyword(@PathParam("keyword") String key) {
        List<Content> get_all_content = new ArrayList();
        if(key.contains(",")){
            String[] all_key =key.split(",");
           
            for(String key_splitted : all_key){
                key_splitted = key_splitted.trim();
                List<Content> list_content = super.findAll();
                for(Content cont: list_content){
                    String key_cont = cont.getKeywords();
                    if(key_cont.contains(key_splitted)){
                        if(!get_all_content.contains(cont))
                            get_all_content.add(cont);
                    }
                } 
            }
            return get_all_content;
        }else{
            List<Content> list_content = super.findAll();
            for(Content cont: list_content){
                String key_cont = cont.getKeywords();
                if(key_cont.contains(key)){
                    get_all_content.add(cont);
                
                }
            }
        return get_all_content; 
        }
    }
    
    
    @PUT
    @Path("modify_title/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void modifyTitle(@PathParam("id") Integer id, String title) {
        Content con = super.find(id);
        con.setTitle(title);
        super.edit(con);
    }
    
        
    @PUT
    @Path("modify_description/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void modifyDescription(@PathParam("id") Integer id, String description) {
        Content con = super.find(id);
        con.setDescription(description);
        super.edit(con);
    } 
    
    
    @GET
    @Path("/download/{id}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadFileId(@PathParam("id")Integer id)throws IOException {
        Content con = super.find(id);
        System.out.println("Descarga del archivo" +id);
        File file_to_download = new File(con.getTitle());
        BufferedWriter bf = null;           
        try {
            bf = new BufferedWriter(new FileWriter(file_to_download)); 
            bf.write("Archivo de la BDD");
            bf.newLine();
            bf.write(con.toString());          
            bf.flush();
        } catch (IOException e) {
            Logger.getLogger(ContentFacadeREST.class.getName()).log(Level.SEVERE, null, con);
        }
        assert bf != null;
        bf.close(); 
	ResponseBuilder response = Response.ok((Object) file_to_download);
	response.header("Content-Disposition", "attachment;filename=" + con.getTitle());
	return response.build();
    }
    
    @GET
    @Path("/download/")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadFiles()throws IOException {
        List<Content> list_con = super.findAll();
	System.out.println("Descarga de los archivos");
	File file_to_download = new File("Archivos.txt");
        BufferedWriter bf = null;           
        try {
            bf = new BufferedWriter( new FileWriter(file_to_download) );
            bf.write("Archivos de la BDD");
            bf.newLine();
            for(Content con: list_con){
                bf.write(con.toString());          
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            Logger.getLogger(ContentFacadeREST.class.getName()).log(Level.SEVERE, null, list_con);
        }
        assert bf != null;
        bf.close(); 
	ResponseBuilder response = Response.ok((Object) file_to_download);
	response.header("Content-Disposition", "attachment;filename=" + "Archivos.txt");
	return response.build();
    }
    
    
    
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
