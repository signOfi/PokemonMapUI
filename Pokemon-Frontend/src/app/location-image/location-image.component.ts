import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-location-image',
  templateUrl: './location-image.component.html',
  styleUrls: ['./location-image.component.css']
})
export class LocationImageComponent {
  @Input() locationName: string = '';
  @Input() imageSrc: string = '';
}
