import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class VerifyService {

  rootUrl = 'http://localhost:8088/api/verifier';

  constructor(
    private httpClient: HttpClient
  ) {
  }

  verifyFunctional(file: string, start: string) {
    let url = this.rootUrl + '/verify-functional';
    let map = {'file': file, 'start': start};
    return this.httpClient.post<object>(url, map);
  }

  verifyNonFunctional(file: string) {
    let url = this.rootUrl + '/verify-non-functional';
    return this.httpClient.post<string>(url, file);
  }
}
