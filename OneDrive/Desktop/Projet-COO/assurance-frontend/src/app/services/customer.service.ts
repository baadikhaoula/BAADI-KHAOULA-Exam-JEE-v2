import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from '../models/customer';

@Injectable({ providedIn: 'root' })
export class CustomerService {
  private API = 'http://localhost:8085/api/customers';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.API);
  }

  getById(id: number): Observable<Customer> {
    return this.http.get<Customer>(`${this.API}/${id}`);
  }

  save(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.API, customer);
  }

  update(id: number, customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(`${this.API}/${id}`, customer);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.API}/${id}`);
  }

  search(keyword: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${this.API}/search?keyword=${keyword}`);
  }
}
