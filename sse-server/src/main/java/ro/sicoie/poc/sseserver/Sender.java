package ro.sicoie.poc.sseserver;

import java.awt.PageAttributes.MediaType;
import java.time.Duration;
import java.time.LocalTime;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class Sender {

  @CrossOrigin(origins = { "http://localhost:4200"})
  @GetMapping(path = "/stream-flux", produces = "text/event-stream")
  public Flux<String> stringFlux() {
    return Flux.interval(Duration.ofSeconds(1))
        .map(seq -> "Time is " + LocalTime.now().toString());
  }

  @GetMapping
  public String index() {
    return "Go to <a href=\"/stream-flux\">stream-flux</a>.";
  }

}
