package com.tutorial.demo.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/hello")
@ApplicationScoped
public class HelloWorldEndpoint {
	List<Task> tasks = new ArrayList<>();
	AtomicInteger idCounter = new AtomicInteger(1);

	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response doGet() {
		return Response.ok("Hello from Thorntail!").build();
	}

	@GET
	@Path("/tasks")
	@Produces(MediaType.APPLICATION_JSON)
	public Response doGetTaskList() {
		System.out.println("returning task list with items: " + tasks.size());
		return Response.ok(tasks).build();
	}

	@GET
	@Path("/tasks/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response doGetTask(@PathParam("id") int id) {
		System.out.println("returning task list with items: " + tasks.size());
		Task found = tasks
						.stream()
				        .filter(task -> task.getId() == id)
						.findAny()
						.orElse(Task.from(1000, "default"));
		return Response.ok(found).build();
	}

	@POST
	@Path("/task")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTask(Task task) throws URISyntaxException {
		System.out.println("adding task: name: " + task.getName());
		int id = idCounter.getAndIncrement();
		tasks.add(Task.from(id, task.getName()));
		System.out.println("task list size: " + tasks.size());
		return Response.created(new URI("/hello/task/"+id)).build();
	}

	@GET
	@Path("/greetings.json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response doGetJson() {
		return Response.ok(Greeting.from("miztli", "Hola")).build();
	}

	@GET
	@Path("/greetings.xml")
	@Produces(MediaType.APPLICATION_XML)
	public Response doGetXML() {
		return Response.ok(Greeting.from("miztli", "Hola")).build();
	}

}
