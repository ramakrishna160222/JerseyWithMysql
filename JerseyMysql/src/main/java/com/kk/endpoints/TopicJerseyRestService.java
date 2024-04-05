package com.kk.endpoints;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.kk.entity.Topic;
import com.kk.service.TopicService;

import ch.qos.logback.core.status.Status;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Component
@Path("/topics")
public class TopicJerseyRestService {
	
		private static final Logger logger=org.slf4j.LoggerFactory.getLogger(TopicJerseyRestService.class);
		
		@Autowired
		private TopicService ts;
		
		@POST
		@Path("/create")
		@Consumes(MediaType.APPLICATION_JSON)
		@CrossOrigin
		public Response createTopic(Topic topic) {
			boolean isAdded=ts.addTopic(topic);
			if(!isAdded) {
				logger.info("Topic already exists");
				return Response.status(Status.ERROR).build();
			}
			return Response.created(URI.create("/topics/topic/" + topic.getTopicId())).build();
		}
		
		@PUT
		@Path("/topic/update")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		@CrossOrigin
		public Response updateTopic(Topic topic) {
			ts.updateTopic(topic);
			return Response.ok(topic).build();
		}
		
		@GET
		@Path("/topicId/{topicId}")
		@Produces(MediaType.APPLICATION_JSON)
		@CrossOrigin
		public Response getTopicById(@PathParam("topicId") int topicId) {
			Topic topic=ts.getTopicById(topicId);
			return Response.ok(topic).build();
		}
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@CrossOrigin
		public Response getAllTopics() {
			List<Topic> list=ts.getAllTopics();
			return Response.ok(list).build();
		}
		
		@DELETE
		@Path("/topicId/{topicId}")
		@Consumes(MediaType.APPLICATION_JSON)
		@CrossOrigin
		public Response deleteTopic(@PathParam("topicId") int topicId) {
			ts.deleteTopic(topicId);
			return Response.noContent().build();
		}
		
		
}
