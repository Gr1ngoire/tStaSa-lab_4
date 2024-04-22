import styles from "./styles.module.css";

type Props = {
  placeholder: string;
  onChange?: (e: React.ChangeEvent<HTMLInputElement>) => void;
  type?: string;
  label?: string;
  value?: string;
  name?: string;
};

const Input: React.FC<Props> = ({
  placeholder,
  onChange,
  type,
  label,
  value,
  name,
}) => {
  return (
    <div className={styles.inputContainer}>
      {label && <label className={styles.label}>{label}</label>}
      <input
        className={styles.input}
        placeholder={placeholder}
        onChange={onChange}
        type={type}
        value={value}
        name={name}
      />
    </div>
  );
};

export { Input };
