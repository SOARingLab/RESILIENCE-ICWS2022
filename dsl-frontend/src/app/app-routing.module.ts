import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {IndexComponent} from "./component/index/index.component";
import {EditorComponent} from "./component/editor/editor.component";
import {GeneratorComponent} from "./component/generator/generator.component";
import {EditComponent} from "./component/edit/edit.component";
import {PublicApiComponent} from "./component/public-api/public-api.component";
import {PublicApiListComponent} from "./component/public-api-list/public-api-list.component";
import {VerifyComponent} from "./component/verify/verify.component";

const routes: Routes = [
  {path: '', redirectTo: '/index', pathMatch: 'full'},
  {path: 'index', component: IndexComponent},
  {path: 'editor', component: EditorComponent},
  {path: 'generator', component: GeneratorComponent},
  {path: 'edit', component: EditComponent},
  {path: 'public-api-list', component: PublicApiListComponent},
  {path: 'public-api/:id', component: PublicApiComponent},
  {path: 'verify', component: VerifyComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
