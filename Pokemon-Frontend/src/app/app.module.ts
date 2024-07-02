import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PokemonImageComponent } from './pokemon-image/pokemon-image.component';
import { MapComponent } from './map/map.component';
import { InformationComponent } from './information/information.component';
import { LocationImageComponent } from './location-image/location-image.component';
import { LocationService } from "./services/location.service";

@NgModule({
  declarations: [
    AppComponent,
    PokemonImageComponent,
    MapComponent,
    InformationComponent,
    LocationImageComponent
  ],
  imports: [
    BrowserModule.withServerTransition({ appId: 'serverApp' }),
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [LocationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
