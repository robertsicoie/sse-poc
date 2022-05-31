import { Component, OnInit } from '@angular/core';

import { SseClient } from 'angular-sse-client';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent implements OnInit {
  title = 'sse-client-angular';
  data = '';

  constructor(private sseClient: SseClient) {
  }

  ngOnInit(): void {
    this.sseClient.get('http://localhost:8080/stream-flux')
      .subscribe(data => {
        this.data = data;
        console.log('got: ', data);
      });
  }
}
