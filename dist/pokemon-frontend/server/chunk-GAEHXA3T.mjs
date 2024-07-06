import './polyfills.server.mjs';
import{A as K,B as q,C as u,D as v,E as N,F as Q,G as Z,O as X,P as I,Q as J,R as ee,S as te,T as ne,U as ie,X as oe,a as R,b as E,ba as F,c as H,d as C,e as V,f as U,g as p,h as d,i as z,j as B,k as $,l as O,m as g,n as T,o as k,p as b,q as f,r as S,s as n,t as i,u as _,v as L,w as s,x as w,y as Y,z as W}from"./chunk-GFTTZ5WN.mjs";var ge=[],re=(()=>{let r=class r{};r.\u0275fac=function(l){return new(l||r)},r.\u0275mod=V({type:r}),r.\u0275inj=E({imports:[F.forRoot(ge),F]});let a=r;return a})();var A=(()=>{let r=class r{constructor(o){this.http=o,this.apiUrl="http://localhost:8080/pokemon"}getLocationById(o){return this.http.get(`${this.apiUrl}/encounters/${o}`)}getLocationByName(o){return this.http.get(`${this.apiUrl}/getLocationDTO/${o}`)}getEncountersByMethodsVersionAndTime(o,l,t,c){let m=new ee().set("encounterMethods",l.join(",")).set("version",t).set("requestedTime",c);return this.http.get(`${this.apiUrl}/encounters/${o}`,{params:m})}};r.\u0275fac=function(l){return new(l||r)(H(te))},r.\u0275prov=R({token:r,factory:r.\u0275fac,providedIn:"root"});let a=r;return a})();var he=["mapOverlay"],ce=(()=>{let r=class r{constructor(){this.locationSelected=new $,this.selectedArea=null}ngOnInit(){}ngAfterViewInit(){this.initializeMap()}initializeMap(){let o=this.mapOverlay.nativeElement,l=o.querySelector("#tooltip"),t=o.querySelector("#tooltip-text");if(!l||!t){console.error("Tooltip elements not found");return}o.addEventListener("mousemove",m=>{let e=o.createSVGPoint();e.x=m.clientX,e.y=m.clientY;let D=e.matrixTransform(o.getScreenCTM().inverse());l.setAttribute("transform",`translate(${D.x+10}, ${D.y+10})`)}),o.querySelectorAll(".map-area").forEach(m=>{m.addEventListener("mouseenter",e=>{let j=e.target.getAttribute("data-name");t instanceof SVGTextElement&&j&&(t.textContent=j,l.setAttribute("visibility","visible"))}),m.addEventListener("mouseleave",()=>{l.setAttribute("visibility","hidden")})})}onAreaClick(o,l){this.selectedArea&&this.selectedArea.classList.remove("selected");let t=l.target;t.classList.add("selected"),this.selectedArea=t,this.locationSelected.emit(o)}};r.\u0275fac=function(l){return new(l||r)},r.\u0275cmp=C({type:r,selectors:[["app-map"]],viewQuery:function(l,t){if(l&1&&W(he,7),l&2){let c;K(c=q())&&(t.mapOverlay=c.first)}},outputs:{locationSelected:"locationSelected"},decls:67,vars:0,consts:[["mapOverlay",""],[1,"map-container"],["src","assets/map.png","alt","Pok\xE9mon Map",1,"map-image"],["viewBox","0 0 800 600","xmlns","http://www.w3.org/2000/svg",1,"map-overlay"],["x","345","y","265","width","70","height","70","rx","10","ry","10","data-name","Violet City",1,"map-area",3,"click"],["x","276","y","504","width","70","height","35","rx","10","ry","10","data-name","Azalea Town",1,"map-area",3,"click"],["x","176","y","368","width","100","height","68","rx","10","ry","10","data-name","Goldenrod City",1,"map-area",3,"click"],["x","39.5","y","368","width","35","height","68","rx","10","ry","10","data-name","Cianwood City",1,"map-area",3,"click"],["x","411","y","197","width","36","height","36","rx","10","ry","10","data-name","Mahogany Town",1,"map-area",3,"click"],["x","411","y","433","width","70","height","37","rx","10","ry","10","data-name","Cherrygrove City",1,"map-area",3,"click"],["x","582","y","435","width","34","height","36","rx","10","ry","10","data-name","New Bark Town",1,"map-area",3,"click"],["x","242","y","163","width","70","height","70","rx","10","ry","10","data-name","Ecruteak City",1,"map-area",3,"click"],["x","140","y","266","width","70","height","70","rx","10","ry","10","data-name","Olivine City",1,"map-area",3,"click"],["x","548","y","163","width","70","height","70","rx","10","ry","10","data-name","Blackthorn City",1,"map-area","blackthorn-city",3,"click"],["x","353","y","343","width","17","height","129","data-name","Route 32",1,"map-area",3,"click"],["x","353","y","505","width","17","height","24","data-name","Route 33",1,"map-area",3,"click"],["x","251","y","444","width","15","height","60","data-name","Route 34",1,"map-area",3,"click"],["x","250","y","290","width","17","height","70","data-name","Route 35",1,"map-area",3,"click"],["x","270","y","275","width","68","height","17","data-name","Route 36",1,"map-area",3,"click"],["x","284.5","y","240","width","16","height","34","data-name","Route 37",1,"map-area",3,"click"],["x","-53","y","368","width","50","height","40","data-name","Route 48",1,"map-area",3,"click"],["x","-53","y","408","width","85","height","52.5","data-name","Route 47",1,"map-area",3,"click"],["x","81","y","375","width","52","height","53","rx","10","ry","10","data-name","Route 41",1,"map-area",3,"click"],["x","117","y","310","width","14.5","height","67","data-name","Route 40",1,"map-area",3,"click"],["x","149","y","207","width","16","height","50","data-name","Route 39",1,"map-area",3,"click"],["x","168","y","207","width","67","height","17","data-name","Route 38",1,"map-area",3,"click"],["x","454","y","207","width","85","height","16.5","data-name","Route 44",1,"map-area",3,"click"],["x","420","y","140","width","18","height","51","data-name","Route 43",1,"map-area",3,"click"],["x","751","y","311","width","68","height","15","data-name","Route 28",1,"map-area",3,"click"],["x","854","y","311","width","36","height","15","data-name","Route 22",1,"map-area",3,"click"],["x","420","y","308","width","29","height","18","data-name","Route 31",1,"map-area",3,"click"],["x","454","y","331","width","20","height","97","data-name","Route 30",1,"map-area",3,"click"],["x","522","y","402","width","18","height","41","data-name","Route 46",1,"map-area",3,"click"],["x","488","y","445","width","87","height","16","data-name","Route 29",1,"map-area",3,"click"],["x","557","y","264","width","16","height","129","data-name","Route 45",1,"map-area",3,"click"],["x","624","y","446.2","width","200","height","15.5","data-name","Route 27",1,"map-area",3,"click"],["x","320","y","207","width","83","height","16.5","data-name","Route 42",1,"map-area","route42",3,"click"],["x","829","y","332","width","14","height","128","data-name","Route 26",1,"map-area",3,"click"],["x","310","y","300","width","35","height","70","rx","10","ry","10","data-name","Ruins of Alph",1,"map-area",3,"click"],["x","351","y","475","width","22","height","25","rx","10","ry","10","data-name","Union Cave",1,"map-area",3,"click"],["x","248","y","508","width","21","height","25","rx","10","ry","10","data-name","Ilex Forest",1,"map-area",3,"click"],["x","111","y","404","width","23","height","23","rx","10","ry","10","data-name","Whirl Islands",1,"map-area","whirl-islands",3,"click"],["x","379","y","62","width","102","height","71","rx","10","ry","10","data-name","Lake of Rage",1,"map-area",3,"click"],["x","521","y","373","width","21","height","22","rx","10","data-name","Dark cave Route 45",1,"map-area",3,"click"],["x","555","y","240","width","21","height","22","rx","10","data-name","Dark cave Route 45",1,"map-area",3,"click"],["x","450","y","303","width","27","height","27","rx","10","ry","10","data-name","Dark Cave Route 31",1,"map-area",3,"click"],["x","90.5","y","247.3","width","33","height","38","rx","10","ry","10","data-name","Battle Frontier",1,"map-area",3,"click"],["x","225","y","249","width","35","height","36","rx","10","ry","10","data-name","National Park",1,"map-area",3,"click"],["x","-54","y","308.5","width","53","height","53","rx","10","ry","10","data-name","Safari Zone Gate",1,"map-area",3,"click"],["x","827","y","275","width","18","height","52","rx","10","ry","10","data-name","Victory Road",1,"map-area",3,"click"],["x","725","y","307","width","20","height","22","rx","10","data-name","Mt Silver",1,"map-area",3,"click"],["x","827","y","240","width","18","height","33","rx","10","ry","10","data-name","Indigo Plateau",1,"map-area",3,"click"],["x","382","y","270","width","25","height","25","rx","10","ry","10","data-name","Sprout Tower",1,"map-area","sprout-tower",3,"click"],["x","317","y","509","width","21","height","21","rx","10","ry","10","data-name","Slowpoke Well",1,"map-area","slowpoke-well",3,"click"],["x","248","y","170","width","24","height","24","rx","10","ry","10","data-name","Burned Tower",1,"map-area","burned-tower",3,"click"],["x","282","y","169","width","24","height","24","rx","10","ry","10","data-name","Bell Tower",1,"map-area","bell-tower",3,"click"],["x","180","y","305","width","24","height","24","rx","10","ry","10","data-name","Shining Lighthouse",1,"map-area","shining-lighthouse",3,"click"],["x","560","y","135","width","25","height","25","rx","10","ry","10","data-name","Dragon's Den",1,"map-area","dragons-den",3,"click"],["x","655","y","441","width","24","height","23","rx","10","ry","10","data-name","Tohjo Falls",1,"map-area","tohjo-falls",3,"click"],["x","586","y","168","width","25","height","25","rx","10","ry","10","data-name","Ice Path",1,"map-area","ice-path",3,"click"],["x","353","y","207","width","17","height","18.7","rx","10","ry","10","data-name","Mt. Mortar",1,"map-area","mt-mortar",3,"click"],["id","tooltip","visibility","hidden"],["id","tooltip-bg","x","0","y","0","width","140","height","30","rx","5","ry","5"],["id","tooltip-text","x","70","y","15","text-anchor","middle","dominant-baseline","middle","fill","white"],["id","info-panel",1,"info-panel"],["id","info-description"]],template:function(l,t){if(l&1){let c=L();n(0,"div",1),_(1,"img",2),z(),n(2,"svg",3,0)(4,"rect",4),s("click",function(e){return p(c),d(t.onAreaClick("Violet City",e))}),i(),n(5,"rect",5),s("click",function(e){return p(c),d(t.onAreaClick("Azalea Town",e))}),i(),n(6,"rect",6),s("click",function(e){return p(c),d(t.onAreaClick("Goldenrod City",e))}),i(),n(7,"rect",7),s("click",function(e){return p(c),d(t.onAreaClick("Cianwood City",e))}),i(),n(8,"rect",8),s("click",function(e){return p(c),d(t.onAreaClick("Mahogany Town",e))}),i(),n(9,"rect",9),s("click",function(e){return p(c),d(t.onAreaClick("Cherrygrove City",e))}),i(),n(10,"rect",10),s("click",function(e){return p(c),d(t.onAreaClick("New Bark Town",e))}),i(),n(11,"rect",11),s("click",function(e){return p(c),d(t.onAreaClick("Ecruteak City",e))}),i(),n(12,"rect",12),s("click",function(e){return p(c),d(t.onAreaClick("Olivine City",e))}),i(),n(13,"rect",13),s("click",function(e){return p(c),d(t.onAreaClick("Blackthorn City",e))}),i(),n(14,"rect",14),s("click",function(e){return p(c),d(t.onAreaClick("Route 32",e))}),i(),n(15,"rect",15),s("click",function(e){return p(c),d(t.onAreaClick("Route 33",e))}),i(),n(16,"rect",16),s("click",function(e){return p(c),d(t.onAreaClick("Route 34",e))}),i(),n(17,"rect",17),s("click",function(e){return p(c),d(t.onAreaClick("Route 35",e))}),i(),n(18,"rect",18),s("click",function(e){return p(c),d(t.onAreaClick("Route 36",e))}),i(),n(19,"rect",19),s("click",function(e){return p(c),d(t.onAreaClick("Route 37",e))}),i(),n(20,"rect",20),s("click",function(e){return p(c),d(t.onAreaClick("Route 48",e))}),i(),n(21,"rect",21),s("click",function(e){return p(c),d(t.onAreaClick("Route 47",e))}),i(),n(22,"rect",22),s("click",function(e){return p(c),d(t.onAreaClick("Route 41",e))}),i(),n(23,"rect",23),s("click",function(e){return p(c),d(t.onAreaClick("Route 40",e))}),i(),n(24,"rect",24),s("click",function(e){return p(c),d(t.onAreaClick("Route 39",e))}),i(),n(25,"rect",25),s("click",function(e){return p(c),d(t.onAreaClick("Route 38",e))}),i(),n(26,"rect",26),s("click",function(e){return p(c),d(t.onAreaClick("Route 44",e))}),i(),n(27,"rect",27),s("click",function(e){return p(c),d(t.onAreaClick("Route 43",e))}),i(),n(28,"rect",28),s("click",function(e){return p(c),d(t.onAreaClick("Route 28",e))}),i(),n(29,"rect",29),s("click",function(e){return p(c),d(t.onAreaClick("Route 22",e))}),i(),n(30,"rect",30),s("click",function(e){return p(c),d(t.onAreaClick("Route 31",e))}),i(),n(31,"rect",31),s("click",function(e){return p(c),d(t.onAreaClick("Route 30",e))}),i(),n(32,"rect",32),s("click",function(e){return p(c),d(t.onAreaClick("Route 46",e))}),i(),n(33,"rect",33),s("click",function(e){return p(c),d(t.onAreaClick("Route 29",e))}),i(),n(34,"rect",34),s("click",function(e){return p(c),d(t.onAreaClick("Route 45",e))}),i(),n(35,"rect",35),s("click",function(e){return p(c),d(t.onAreaClick("Route 27",e))}),i(),n(36,"rect",36),s("click",function(e){return p(c),d(t.onAreaClick("Route 42",e))}),i(),n(37,"rect",37),s("click",function(e){return p(c),d(t.onAreaClick("Route 26",e))}),i(),n(38,"rect",38),s("click",function(e){return p(c),d(t.onAreaClick("Ruins of Alph",e))}),i(),n(39,"rect",39),s("click",function(e){return p(c),d(t.onAreaClick("Union Cave",e))}),i(),n(40,"rect",40),s("click",function(e){return p(c),d(t.onAreaClick("Ilex Forest",e))}),i(),n(41,"rect",41),s("click",function(e){return p(c),d(t.onAreaClick("Whirl Islands",e))}),i(),n(42,"rect",42),s("click",function(e){return p(c),d(t.onAreaClick("Lake of Rage",e))}),i(),n(43,"rect",43),s("click",function(e){return p(c),d(t.onAreaClick("Dark cave Route 45",e))}),i(),n(44,"rect",44),s("click",function(e){return p(c),d(t.onAreaClick("Dark cave Route 45",e))}),i(),n(45,"rect",45),s("click",function(e){return p(c),d(t.onAreaClick("Dark cave Route 31",e))}),i(),n(46,"rect",46),s("click",function(e){return p(c),d(t.onAreaClick("Battle Frontier",e))}),i(),n(47,"rect",47),s("click",function(e){return p(c),d(t.onAreaClick("National Park",e))}),i(),n(48,"rect",48),s("click",function(e){return p(c),d(t.onAreaClick("Safari Zone Gate",e))}),i(),n(49,"rect",49),s("click",function(e){return p(c),d(t.onAreaClick("Victory Road",e))}),i(),n(50,"rect",50),s("click",function(e){return p(c),d(t.onAreaClick("Mt Silver",e))}),i(),n(51,"rect",51),s("click",function(e){return p(c),d(t.onAreaClick("Indigo Plateau",e))}),i(),n(52,"rect",52),s("click",function(e){return p(c),d(t.onAreaClick("Sprout Tower",e))}),i(),n(53,"rect",53),s("click",function(e){return p(c),d(t.onAreaClick("Slowpoke Well",e))}),i(),n(54,"rect",54),s("click",function(e){return p(c),d(t.onAreaClick("Burned Tower",e))}),i(),n(55,"rect",55),s("click",function(e){return p(c),d(t.onAreaClick("Bell Tower",e))}),i(),n(56,"rect",56),s("click",function(e){return p(c),d(t.onAreaClick("Shining Lighthouse",e))}),i(),n(57,"rect",57),s("click",function(e){return p(c),d(t.onAreaClick("Dragon's Den",e))}),i(),n(58,"rect",58),s("click",function(e){return p(c),d(t.onAreaClick("Tohjo Falls",e))}),i(),n(59,"rect",59),s("click",function(e){return p(c),d(t.onAreaClick("Ice Path",e))}),i(),n(60,"rect",60),s("click",function(e){return p(c),d(t.onAreaClick("Mt. Mortar",e))}),i(),n(61,"g",61),_(62,"rect",62)(63,"text",63),i()()(),B(),n(64,"div",64)(65,"p",65),u(66,"Click on a map area to learn more."),i()()}},styles:[".map-container[_ngcontent-%COMP%]{position:relative;width:100%;height:0;padding-bottom:75%;overflow:hidden;box-shadow:0 4px 6px #0000001a;border-radius:10px;background-color:#1e2a3a}.map-image[_ngcontent-%COMP%]{position:absolute;top:0;left:0;width:100%;height:100%;object-fit:contain}.map-overlay[_ngcontent-%COMP%]{position:absolute;top:0;left:0;width:100%;height:100%}.map-area[_ngcontent-%COMP%]{fill:#ffffff1a;stroke:none;cursor:pointer;transition:all .3s ease}.map-area[_ngcontent-%COMP%]:hover{fill:#e5dfa585;stroke:#756c02;stroke-width:2px;filter:drop-shadow(0 0 3px rgba(255,255,255,.7))}.map-area.selected[_ngcontent-%COMP%]{fill:#ffd70099;stroke:gold;stroke-width:3px;animation:_ngcontent-%COMP%_blink 1s infinite alternate}@keyframes _ngcontent-%COMP%_blink{0%{opacity:.7}to{opacity:1}}#tooltip-bg[_ngcontent-%COMP%]{fill:#000000b3}#tooltip-text[_ngcontent-%COMP%]{font-size:12px;font-family:Arial,sans-serif}.info-panel[_ngcontent-%COMP%]{margin-top:10px;padding:10px 15px;background-color:#2c3e50;border-radius:5px;box-shadow:0 2px 4px #0000001a;color:#ecf0f1;font-family:Arial,sans-serif;transition:all .3s ease}.info-panel[_ngcontent-%COMP%]   h2[_ngcontent-%COMP%]{margin-top:0;color:#3498db;font-size:24px;border-bottom:2px solid #3498db;padding-bottom:10px}.info-panel[_ngcontent-%COMP%]   p[_ngcontent-%COMP%]{margin:0;color:#bdc3c7;font-size:14px;line-height:1.4}#tooltip-bg[_ngcontent-%COMP%]{fill:#000c;stroke:#3498db;stroke-width:1px}#tooltip-text[_ngcontent-%COMP%]{font-size:12px;font-family:Arial,sans-serif;font-weight:700}.map-container[_ngcontent-%COMP%]:hover   .map-image[_ngcontent-%COMP%]{filter:brightness(1.05)}@media (min-width: 768px){.map-container[_ngcontent-%COMP%]{padding-bottom:66.67%}}@media (min-width: 1024px){.map-container[_ngcontent-%COMP%]{padding-bottom:60%}}@media (min-width: 1367px){.map-container[_ngcontent-%COMP%]{padding-bottom:56.25%}}"]});let a=r;return a})();var x=function(a){return a.HG="HG",a.SS="SS",a}(x||{});var M=function(a){return a.DAY="DAY",a.NIGHT="NIGHT",a.MORNING="MORNING",a}(M||{});var P=function(a){return a.WALKING="WALKING",a.SURFING="SURFING",a.OLD_ROD="OLD_ROD",a.GOOD_ROD="GOOD_ROD",a.SUPER_ROD="SUPER_ROD",a.GIFT="GIFT",a.ENCOUNTER="ENCOUNTER",a.ROCK_SMASH="ROCK_SMASH",a}(P||{});var le=(()=>{let r=class r{ngOnInit(){this.imagePath=this.getImagePath(this.pokemonName)}getImagePath(o){return"assets/pokemonSprites/"+(o.charAt(0).toUpperCase()+o.slice(1))+".png"}};r.\u0275fac=function(l){return new(l||r)},r.\u0275cmp=C({type:r,selectors:[["app-pokemon-image"]],inputs:{pokemonName:"pokemonName"},decls:2,vars:3,consts:[[1,"pokemon-container"],[1,"pokemon-image",3,"src","alt"]],template:function(l,t){l&1&&(n(0,"div",0),_(1,"img",1),i()),l&2&&(g(),Y("alt","Image of ",t.pokemonName,""),f("src",t.imagePath,O))},styles:[".pokemon-container[_ngcontent-%COMP%]{text-align:center;margin:10px}.pokemon-image[_ngcontent-%COMP%]{width:50px;height:auto}h3[_ngcontent-%COMP%]{color:#333;margin-top:5px}"]});let a=r;return a})();function Ce(a,r){if(a&1){let h=L();n(0,"button",4),s("click",function(){let l=p(h).$implicit,t=w();return d(t.toggleMethod(t.EncounterMethod[l]))}),u(1),i()}if(a&2){let h=r.$implicit,o=w();S("active",o.defaultMethods.has(o.EncounterMethod[h])),b("data-method",h),g(),N(" ",o.formatMethodName(h)," ")}}function ke(a,r){a&1&&(n(0,"th"),u(1,"Sub Level"),i())}function we(a,r){if(a&1&&(n(0,"td"),u(1),i()),a&2){let h=w().$implicit;g(),v(h.subLevel)}}function xe(a,r){if(a&1&&(n(0,"tr"),k(1,we,2,1,"td",12),n(2,"td"),_(3,"app-pokemon-image",14),i(),n(4,"td"),u(5),Q(6,"titlecase"),i(),n(7,"td"),u(8),i(),n(9,"td"),u(10),i(),n(11,"td"),u(12),i(),n(13,"td"),u(14),i(),n(15,"td"),_(16,"img",15),i(),n(17,"td"),_(18,"img",16),i()()),a&2){let h=r.$implicit,o=w();g(),f("ngIf",o.hasSubLevels()),g(2),f("pokemonName",h.pokemonName),g(2),v(Z(6,11,h.pokemonName)),g(3),N("",h.encounterRate,"%"),g(2),v(h.minLevel),g(2),v(h.maxLevel),g(2),N(" ",o.formatEncounterMethod(h.encounterMethod)," "),g(2),f("src",o.getVersionImage(o.getVersionString(h.versions)),O)("alt",o.currentVersion),g(2),f("src",o.getTimeImage(o.getTimeString(h.timeOfEncounter)),O)("alt",o.currentTimeOfEncounter)}}var me=(()=>{let r=class r{constructor(o){this.locationService=o,this.currentLocation=null,this.locations=[],this.defaultMethods=new Set([P.WALKING,P.SURFING]),this.allMethods=Object.values(P),this.currentVersion=x.HG,this.currentTimeOfEncounter=M.MORNING,this.EncounterMethod=P,this.GameVersion=x,this.TimeOfEncounter=M,this.Array=Array}ngOnChanges(o){console.log("ngOnChanges called, location:",this.location),o.location&&(this.currentLocation=Array.isArray(this.location)?this.location[0]:this.location,this.currentLocation&&this.currentLocation.id&&this.loadEncounters())}loadEncounters(){if(console.log("loadEncounters called, currentLocation:",this.currentLocation),!this.currentLocation||!this.currentLocation.id){console.error("Location or location ID is undefined");return}this.locationService.getEncountersByMethodsVersionAndTime(this.currentLocation.id,Array.from(this.defaultMethods),this.currentVersion,this.currentTimeOfEncounter).subscribe({next:o=>{console.log("Encounters loaded:",o),this.locations=o},error:o=>console.error("Failed to fetch data:",o)})}toggleMethod(o){this.defaultMethods.has(o)?this.defaultMethods.delete(o):this.defaultMethods.add(o),this.defaultMethods.size===0&&this.defaultMethods.add(P.WALKING),this.loadEncounters()}toggleVersion(){this.currentVersion=this.currentVersion===x.HG?x.SS:x.HG,this.loadEncounters()}toggleTimeOfEncounter(){this.currentTimeOfEncounter=this.currentTimeOfEncounter===M.DAY?M.NIGHT:M.DAY,this.loadEncounters()}setTimeOfEncounter(o){this.currentTimeOfEncounter=o,this.loadEncounters()}formatEncounterMethods(o){return o.map(l=>l.split("_").map(t=>t.charAt(0).toUpperCase()+t.slice(1).toLowerCase()).join(" ")).join(", ")}formatMethodName(o){return o.replace(/_/g," ").toLowerCase().replace(/\b\w/g,l=>l.toUpperCase())}getVersionImage(o){return o===x.HG?"assets/versions/heartgold.png":o===x.SS?"assets/versions/soulsilver.png":this.currentVersion===x.HG?"assets/versions/heartgold.png":"assets/versions/soulsilver.png"}getTimeImage(o){return o===M.MORNING?"assets/timeOfDay/morning-icon.png":o===M.DAY?"assets/timeOfDay/day-icon.png":o===M.NIGHT?"assets/timeOfDay/night-icon.png":`assets/timeOfDay/${this.currentTimeOfEncounter.toLowerCase()}-icon.png`}getVersionString(o){return o.includes(this.currentVersion)?this.currentVersion:null}getTimeString(o){return o.includes(this.currentTimeOfEncounter)?this.currentTimeOfEncounter:null}formatEncounterMethod(o){return o.split("_").map(l=>l.charAt(0).toUpperCase()+l.slice(1).toLowerCase()).join(" ")}hasSubLevels(){return this.locations.some(o=>o.encounters.some(l=>l.subLevel!=null&&l.subLevel.trim()!==""))}};r.\u0275fac=function(l){return new(l||r)(T(A))},r.\u0275cmp=C({type:r,selectors:[["app-information"]],inputs:{location:"location"},features:[U],decls:47,vars:18,consts:[[1,"controls-container"],[1,"version-section"],[1,"section-label"],[1,"button-grid","version-buttons"],[3,"click"],[1,"method-section"],[1,"button-grid","method-buttons"],[3,"active","click",4,"ngFor","ngForOf"],[1,"time-section"],[1,"button-grid","time-buttons"],[1,"table-container"],[1,"encounter-table"],[4,"ngIf"],[4,"ngFor","ngForOf"],[3,"pokemonName"],[1,"version-icon",3,"src","alt"],[1,"time-icon",3,"src","alt"]],template:function(l,t){l&1&&(n(0,"div",0)(1,"div",1)(2,"span",2),u(3,"Versions"),i(),n(4,"div",3)(5,"button",4),s("click",function(){return t.toggleVersion()}),u(6,"HeartGold"),i(),n(7,"button",4),s("click",function(){return t.toggleVersion()}),u(8,"SoulSilver"),i()()(),n(9,"div",5)(10,"span",2),u(11,"Encounter Methods"),i(),n(12,"div",6),k(13,Ce,2,4,"button",7),i()(),n(14,"div",8)(15,"span",2),u(16,"Time of Day"),i(),n(17,"div",9)(18,"button",4),s("click",function(){return t.setTimeOfEncounter(t.TimeOfEncounter.MORNING)}),u(19,"Morning"),i(),n(20,"button",4),s("click",function(){return t.setTimeOfEncounter(t.TimeOfEncounter.DAY)}),u(21,"Day"),i(),n(22,"button",4),s("click",function(){return t.setTimeOfEncounter(t.TimeOfEncounter.NIGHT)}),u(23,"Night"),i()()()(),n(24,"div",10)(25,"table",11)(26,"thead")(27,"tr"),k(28,ke,2,0,"th",12),n(29,"th"),u(30,"Pokemon"),i(),n(31,"th"),u(32,"Name"),i(),n(33,"th"),u(34,"Encounter Rate"),i(),n(35,"th"),u(36,"Min Level"),i(),n(37,"th"),u(38,"Max Level"),i(),n(39,"th"),u(40,"Encounter Method"),i(),n(41,"th"),u(42,"Version"),i(),n(43,"th"),u(44,"Time"),i()()(),n(45,"tbody"),k(46,xe,19,13,"tr",13),i()()()),l&2&&(g(5),S("active",t.currentVersion===t.GameVersion.HG),b("data-version",t.GameVersion.HG),g(2),S("active",t.currentVersion===t.GameVersion.SS),b("data-version",t.GameVersion.SS),g(6),f("ngForOf",t.allMethods),g(5),S("active",t.currentTimeOfEncounter===t.TimeOfEncounter.MORNING),b("data-time",t.TimeOfEncounter.MORNING),g(2),S("active",t.currentTimeOfEncounter===t.TimeOfEncounter.DAY),b("data-time",t.TimeOfEncounter.DAY),g(2),S("active",t.currentTimeOfEncounter===t.TimeOfEncounter.NIGHT),b("data-time",t.TimeOfEncounter.NIGHT),g(6),f("ngIf",t.hasSubLevels()),g(18),f("ngForOf",t.locations[0]==null?null:t.locations[0].encounters))},dependencies:[X,I,le,J],styles:["[_nghost-%COMP%]{display:flex;flex-direction:column;height:100%;background-color:#1e3a5a;padding:20px}.controls-container[_ngcontent-%COMP%]{display:grid;grid-template-columns:1fr 2fr 1fr;gap:20px;margin-bottom:20px;max-width:1200px;margin-left:auto;margin-right:auto;background-color:#2c4c6e;flex-shrink:0}.version-section[_ngcontent-%COMP%], .method-section[_ngcontent-%COMP%], .time-section[_ngcontent-%COMP%]{padding:15px;background-color:#ffffff1a;border-radius:8px;display:flex;flex-direction:column;align-items:center;text-align:center}.section-label[_ngcontent-%COMP%]{font-weight:700;color:#fff;font-size:18px;margin-bottom:15px;text-transform:uppercase;letter-spacing:1px}.section-label[_ngcontent-%COMP%], .location-description[_ngcontent-%COMP%]{color:#f0f0f0}.button-grid[_ngcontent-%COMP%]{display:grid;gap:10px}.version-section[_ngcontent-%COMP%]   .button-grid[_ngcontent-%COMP%], .time-section[_ngcontent-%COMP%]   .button-grid[_ngcontent-%COMP%]{grid-template-columns:1fr}.method-section[_ngcontent-%COMP%]   .button-grid[_ngcontent-%COMP%]{grid-template-columns:repeat(2,1fr);grid-template-rows:repeat(4,1fr)}button[_ngcontent-%COMP%]{width:100%;height:40px;padding:0 10px;border:1px solid #13556c;background-color:#fff;color:#13556c;cursor:pointer;border-radius:4px;font-size:14px;font-weight:700;transition:all .3s ease;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;box-shadow:0 2px 4px #0000001a}button[_ngcontent-%COMP%]:hover{background-color:#13556c;color:#fff;transform:translateY(-2px);box-shadow:0 4px 6px #0000001a}button.active[_ngcontent-%COMP%], button[_ngcontent-%COMP%]:hover{background-color:#13556c;color:#fff}.version-buttons[_ngcontent-%COMP%]   .active[data-version=HG][_ngcontent-%COMP%]{background-color:#b99e0b;color:#fff}.version-buttons[_ngcontent-%COMP%]   .active[data-version=SS][_ngcontent-%COMP%]{background-color:silver;color:#fff}.method-buttons[_ngcontent-%COMP%]   .active[data-method=WALKING][_ngcontent-%COMP%]{background-color:#4caf50;color:#fff}.method-buttons[_ngcontent-%COMP%]   .active[data-method=SURFING][_ngcontent-%COMP%]{background-color:#09749a;color:#fff}.method-buttons[_ngcontent-%COMP%]   .active[data-method=OLD_ROD][_ngcontent-%COMP%]{background-color:#7baed2;color:#fff}.method-buttons[_ngcontent-%COMP%]   .active[data-method=GOOD_ROD][_ngcontent-%COMP%]{background-color:#4d9ad0;color:#fff}.method-buttons[_ngcontent-%COMP%]   .active[data-method=SUPER_ROD][_ngcontent-%COMP%]{background-color:#258dd7;color:#fff}.method-buttons[_ngcontent-%COMP%]   .active[data-method=ROCK_SMASH][_ngcontent-%COMP%]{background-color:#cd7f32;color:#fff}.method-buttons[_ngcontent-%COMP%]   .active[data-method=GIFT][_ngcontent-%COMP%]{background-color:pink;color:#fff}.method-buttons[_ngcontent-%COMP%]   .active[data-method=ENCOUNTER][_ngcontent-%COMP%]{background-color:#ad0d45;color:#fff}.time-buttons[_ngcontent-%COMP%]   .active[data-time=MORNING][_ngcontent-%COMP%]{background-color:orange;color:#fff}.time-buttons[_ngcontent-%COMP%]   .active[data-time=DAY][_ngcontent-%COMP%]{background-color:gold;color:#fff}.time-buttons[_ngcontent-%COMP%]   .active[data-time=NIGHT][_ngcontent-%COMP%]{background-color:indigo;color:#fff}.table-container[_ngcontent-%COMP%]{flex-grow:1;overflow-x:auto;overflow-y:auto;border-radius:8px;box-shadow:0 2px 5px #0000001a;width:100%}.encounter-table[_ngcontent-%COMP%]{width:100%;min-width:600px;border-collapse:separate;border-spacing:0;background-color:#fff;border-radius:8px;overflow:hidden}.encounter-table[_ngcontent-%COMP%]   th[_ngcontent-%COMP%], .encounter-table[_ngcontent-%COMP%]   td[_ngcontent-%COMP%]{padding:12px;text-align:center;border-bottom:1px solid #e0e0e0;border-right:1px solid #ccc}.encounter-table[_ngcontent-%COMP%]   th[_ngcontent-%COMP%]{background-color:#7294c9;color:#fff;font-weight:700;text-transform:uppercase;letter-spacing:.5px;position:sticky;top:0;z-index:10}.encounter-table[_ngcontent-%COMP%]   tr[_ngcontent-%COMP%]:last-child   td[_ngcontent-%COMP%]{border-bottom:none}.encounter-table[_ngcontent-%COMP%]   th[_ngcontent-%COMP%]:last-child, .encounter-table[_ngcontent-%COMP%]   td[_ngcontent-%COMP%]:last-child{border-right:none}.encounter-table[_ngcontent-%COMP%]   tr[_ngcontent-%COMP%]:hover{background-color:#e0e0e0}.encounter-table[_ngcontent-%COMP%]   td[_ngcontent-%COMP%]{vertical-align:middle}.app-pokemon-image[_ngcontent-%COMP%]{width:40px;height:40px}.version-icon[_ngcontent-%COMP%], .time-icon[_ngcontent-%COMP%]{width:30px;height:30px;object-fit:contain}@media (max-width: 1024px){.controls-container[_ngcontent-%COMP%]{grid-template-columns:1fr 1fr}.method-section[_ngcontent-%COMP%]{grid-column:span 2}}@media (max-width: 768px){.controls-container[_ngcontent-%COMP%]{grid-template-columns:1fr}.method-section[_ngcontent-%COMP%]{grid-column:auto}.table-container[_ngcontent-%COMP%]{overflow-x:auto}.encounter-table[_ngcontent-%COMP%]   th[_ngcontent-%COMP%], .encounter-table[_ngcontent-%COMP%]   td[_ngcontent-%COMP%]{padding:8px;font-size:12px}}"]});let a=r;return a})();var pe=(()=>{let r=class r{getImagePath(o){return`assets/locationImages/${o.toLowerCase().replace(/\s+/g,"-")}.png`}};r.\u0275fac=function(l){return new(l||r)},r.\u0275prov=R({token:r,factory:r.\u0275fac,providedIn:"root"});let a=r;return a})();function ve(a,r){if(a&1&&(n(0,"div",1)(1,"div",2)(2,"div",3)(3,"h3",4),u(4),i(),_(5,"img",5),i(),n(6,"div",6)(7,"p"),u(8),i()()()()),a&2){let h=w();g(4),v(h.getCurrentLocation().name),g(),f("src",h.getImagePath(),O)("alt",h.getCurrentLocation().name),g(3),v(h.getCurrentLocation().description)}}var de=(()=>{let r=class r{constructor(o){this.locationImageService=o}getCurrentLocation(){return Array.isArray(this.location)?this.location[0]:this.location}getImagePath(){let o=this.getCurrentLocation();return o&&o.name?this.locationImageService.getImagePath(o.name):"assets/locationImages/default.png"}};r.\u0275fac=function(l){return new(l||r)(T(pe))},r.\u0275cmp=C({type:r,selectors:[["app-location-image"]],inputs:{location:"location"},decls:1,vars:1,consts:[["class","location-image-center",4,"ngIf"],[1,"location-image-center"],[1,"content-wrapper"],[1,"location-image-wrapper"],[1,"location-name"],[1,"location-image",3,"src","alt"],[1,"location-description"]],template:function(l,t){l&1&&k(0,ve,9,4,"div",0),l&2&&f("ngIf",t.location)},dependencies:[I],styles:[".location-image-container[_ngcontent-%COMP%]{height:auto;min-height:280px;display:flex;justify-content:center;align-items:center;overflow:hidden;transition:transform .3s ease-in-out}.content-wrapper[_ngcontent-%COMP%]{display:flex;flex-direction:column;align-items:center;width:100%;max-width:600px;background-color:#2c4c6e;border-radius:8px;padding:15px;box-shadow:0 2px 10px #0000004d;border:1px solid rgba(255,255,255,.1)}.location-image-wrapper[_ngcontent-%COMP%]{width:100%;max-width:220px;margin-bottom:10px;display:flex;justify-content:center}.location-image[_ngcontent-%COMP%]{max-width:100%;height:auto;object-fit:cover;border-radius:8px}.location-description[_ngcontent-%COMP%]{color:#fff;font-size:14px;line-height:1.6;text-align:center;margin-top:15px;overflow-y:auto;max-height:120px;padding:10px;background-color:#0003;border-radius:4px}.location-description[_ngcontent-%COMP%]::-webkit-scrollbar{width:5px}.location-description[_ngcontent-%COMP%]::-webkit-scrollbar-track{background:#ffffff1a}.location-description[_ngcontent-%COMP%]::-webkit-scrollbar-thumb{background:#ffffff80;border-radius:5px}.location-name[_ngcontent-%COMP%]{background-color:#1c3c5a;color:#fff;margin:0 0 10px;padding:8px;text-align:center;font-size:18px;border-radius:8px;width:100%}@media (max-width: 768px){.button-grid[_ngcontent-%COMP%]{grid-template-columns:repeat(2,1fr)}button[_ngcontent-%COMP%]{font-size:12px;padding:8px;height:auto}}"]});let a=r;return a})();function be(a,r){if(a&1&&_(0,"app-location-image",9),a&2){let h=w();f("location",h.selectedLocation)}}function Se(a,r){if(a&1&&_(0,"app-information",9),a&2){let h=w();f("location",h.selectedLocation)}}var G=(()=>{let r=class r{constructor(o){this.locationService=o,this.selectedLocation=null}ngOnInit(){this.loadLocation(14)}onLocationSelected(o){this.locationService.getLocationByName(o).subscribe({next:l=>{this.selectedLocation=l},error:l=>{console.error("Error fetching location:",l)}})}loadLocation(o){this.locationService.getLocationById(o).subscribe({next:l=>{this.selectedLocation=l},error:l=>{console.error("Error fetching location:",l)}})}};r.\u0275fac=function(l){return new(l||r)(T(A))},r.\u0275cmp=C({type:r,selectors:[["app-root"]],decls:10,vars:2,consts:[[1,"container"],[1,"left-column"],[1,"map-container"],[3,"locationSelected"],[1,"location-image-container"],[3,"location",4,"ngIf"],[1,"right-column"],[1,"information-container"],["src","assets/hgsslogo.png","alt","Pok\xE9mon HeartGold and SoulSilver",1,"logo-overlay"],[3,"location"]],template:function(l,t){l&1&&(n(0,"div",0)(1,"div",1)(2,"div",2)(3,"app-map",3),s("locationSelected",function(m){return t.onLocationSelected(m)}),i()(),n(4,"div",4),k(5,be,1,1,"app-location-image",5),i()(),n(6,"div",6)(7,"div",7),k(8,Se,1,1,"app-information",5),i()()(),_(9,"img",8)),l&2&&(g(5),f("ngIf",t.selectedLocation),g(3),f("ngIf",t.selectedLocation))},dependencies:[I,ce,me,de],styles:[".container[_ngcontent-%COMP%]{display:flex;flex-direction:column;width:100%;height:100vh;overflow:hidden}.right-column[_ngcontent-%COMP%]{display:flex;flex-direction:column;overflow:hidden}.left-column[_ngcontent-%COMP%], .right-column[_ngcontent-%COMP%]{flex-grow:1;min-width:300px;padding:10px;overflow-y:auto}.map-container[_ngcontent-%COMP%]{margin-bottom:10px}.location-image-container[_ngcontent-%COMP%]{height:auto;min-height:150px;display:flex;justify-content:center;align-items:center;margin-bottom:10px}.information-container[_ngcontent-%COMP%]{overflow-y:auto}.logo-overlay[_ngcontent-%COMP%]{position:fixed;bottom:20px;left:20px;width:200px;height:auto;opacity:.4;pointer-events:none;z-index:1000}@media (min-width: 768px){.container[_ngcontent-%COMP%]{flex-direction:row;overflow:hidden}.left-column[_ngcontent-%COMP%]{flex:3;overflow-y:auto}.right-column[_ngcontent-%COMP%]{flex:2;overflow-y:auto}.map-container[_ngcontent-%COMP%]{margin-bottom:15px}.location-image-container[_ngcontent-%COMP%]{min-height:200px}}@media (min-width: 1024px){.right-column[_ngcontent-%COMP%]{flex:3}.information-container[_ngcontent-%COMP%]{padding:20px}}"]});let a=r;return a})();var ue=(()=>{let r=class r{};r.\u0275fac=function(l){return new(l||r)},r.\u0275mod=V({type:r,bootstrap:[G]}),r.\u0275inj=E({providers:[A],imports:[ie.withServerTransition({appId:"serverApp"}),re,ne]});let a=r;return a})();var Pe=(()=>{let r=class r{};r.\u0275fac=function(l){return new(l||r)},r.\u0275mod=V({type:r,bootstrap:[G]}),r.\u0275inj=E({imports:[ue,oe]});let a=r;return a})();export{Pe as a};
