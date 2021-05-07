package com.Research;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("researches")
public class ResearchResource{
	
	ResearchDAO dao = new ResearchDAO();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Research> getResearches() {
					
		return dao.getResearches();
	}
	
	
	@GET
	@Path("research/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Reserch getResearch(@PathParam("id") int id) {
					
		return dao.getResearch(id);
	}

	
	@POST
	@Path("research")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public String createResearch(Research a1) {

		Researcha = dao.getResearch(a1.getId());
		
		if(a.getId()==0) {
			dao.create(a1);		
			return "Successfully added the Research";
		}else {
			return "Research is allready exist";
		}
	}
	
	
	@PUT
	@Path("research")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public String updateResearch(Research a1) {
		
		Research a = dao.getResearch(a1.getId());
		
		if(a.getId()==0) {
			return "Research is not exist";
		}else {
			dao.update(a1);
			return "Successfully updated";
		}
	}
	
	
	@DELETE
	@Path("research/{id}")
	public String deleteResearch(@PathParam("id") int id) {
		
		Research a = dao.getResearch(id);
		
		if(a.getId()==0) {
			return "Research is not exist";
		}else {
			dao.delete(id);
			return "Successfully deleted";
		}
		
	}
}
