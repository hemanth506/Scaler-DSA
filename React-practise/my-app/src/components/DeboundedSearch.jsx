import { useEffect, useState } from 'react'

export const DebouncedSearch = () => {
  const [text, setText] = useState('')

  useEffect(() => {
    console.log('Input is typed', text)
    const timeOut = setTimeout(() => console.log(`API call is made for ${text}`), 3 * 1000)
    return () => {
      clearTimeout(timeOut)
    }
  }, [text])

  return (
    <>
      <input
        placeholder="Type to search"
        value={text}
        onChange={(e) => setText(e.target.value)}
      />
    </>
  )
}
