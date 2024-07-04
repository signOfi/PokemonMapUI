import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LocationImageService {

  getImagePath(locationName: string): string {
    const formattedName = locationName.toLowerCase().replace(/\s+/g, '-');
    return `assets/locationImages/${formattedName}.png`;
  }

}
