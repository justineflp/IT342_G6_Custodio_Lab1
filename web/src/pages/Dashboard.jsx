import { useState, useEffect } from 'react'
import { useAuth } from '../context/AuthContext'
import { getMe } from '../api/auth'
import styles from './Dashboard.module.css'

export default function Dashboard() {
  const { user, updateUser } = useAuth()
  const [profile, setProfile] = useState(user || null)
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState('')

  useEffect(() => {
    let cancelled = false
    getMe()
      .then((data) => {
        if (!cancelled) {
          setProfile(data)
          updateUser(data)
        }
      })
      .catch((err) => {
        if (!cancelled) setError(err.message || 'Failed to load profile')
      })
      .finally(() => {
        if (!cancelled) setLoading(false)
      })
    return () => { cancelled = true }
  }, [updateUser])

  if (loading) return <div className={styles.card}><p>Loading profile…</p></div>
  if (error) return <div className={styles.card}><p className="error-msg">{error}</p></div>

  return (
    <div className={styles.card}>
      <h1>Dashboard / Profile</h1>
      <div className={styles.profile}>
        <p><strong>ID</strong> {profile?.id}</p>
        <p><strong>Full name</strong> {profile?.fullName}</p>
        <p><strong>Email</strong> {profile?.email}</p>
      </div>
      <p className={styles.note}>You are logged in. Use the Logout button in the header to sign out.</p>
    </div>
  )
}
