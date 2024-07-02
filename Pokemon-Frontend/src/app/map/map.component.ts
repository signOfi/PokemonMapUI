import { Component } from '@angular/core';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent {
  selectedLocation: string | null = null;

  onAreaClick(location: string): void {
    this.selectedLocation = location;
  }
}
