import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { RightSideComponent } from './right-side/right-side.component';
import { BelowMapComponent } from './below-map/below-map.component';
import { PokemonImageComponent } from './pokemon-image/pokemon-image.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RightSideComponent,
    BelowMapComponent,
    PokemonImageComponent
  ],
  imports: [
    BrowserModule.withServerTransition({ appId: 'serverApp' }),
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
