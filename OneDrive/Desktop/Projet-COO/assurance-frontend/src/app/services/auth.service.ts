// services/auth.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private API = 'http://localhost:8085/api/auth';

  constructor(private http: HttpClient, private router: Router) {}

  login(username: string, password: string) {
    return this.http.post<any>(`${this.API}/login`, { username, password });
  }

  saveToken(token: string) {
    localStorage.setItem('jwt-token', token);
  }

  getToken(): string | null {
    return localStorage.getItem('jwt-token');
  }

  getRoles(): string[] {
    const token = this.getToken();
    if (!token) return [];
    const payload = JSON.parse(atob(token.split('.')[1]));
    return payload.roles || [];
  }

  isAdmin(): boolean { return this.getRoles().includes('ROLE_ADMIN'); }
  isEmploye(): boolean { return this.getRoles().includes('ROLE_EMPLOYE'); }
  isLoggedIn(): boolean { return !!this.getToken(); }

  logout() {
    localStorage.removeItem('jwt-token');
    this.router.navigate(['/login']);
  }
}
