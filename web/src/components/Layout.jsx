import { Link, useNavigate } from 'react-router-dom'
import { useAuth } from '../context/AuthContext'
import styles from './Layout.module.css'

export default function Layout({ children }) {
  const { token, user, logout } = useAuth()
  const navigate = useNavigate()

  const handleLogout = () => {
    logout()
    navigate('/login')
  }

  return (
    <div className={styles.wrapper}>
      <header className={styles.header}>
        <Link to="/" className={styles.logo}>IT342 Auth</Link>
        <nav className={styles.nav}>
          {token ? (
            <>
              <Link to="/dashboard">Dashboard</Link>
              <span className={styles.user}>Hello, {user?.fullName || user?.email || 'User'}</span>
              <button type="button" className={styles.logoutBtn} onClick={handleLogout}>
                Logout
              </button>
            </>
          ) : (
            <>
              <Link to="/login">Login</Link>
              <Link to="/register">Register</Link>
            </>
          )}
        </nav>
      </header>
      <main className={styles.main}>{children}</main>
    </div>
  )
}
